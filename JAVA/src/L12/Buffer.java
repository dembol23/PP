package L12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private int number;
    private final Queue<Integer> queue;
    private final Semaphore sem_empty;
    private final Semaphore sem_full;
    private final Semaphore mutex;

    public Buffer() {
        sem_empty = new Semaphore(1);
        sem_full = new Semaphore(0);
        queue = null;
        mutex = null;
    }

    public Buffer(int buffer_size) {
        sem_empty = new Semaphore(buffer_size);
        sem_full = new Semaphore(0);
        mutex = new Semaphore(1);
        queue = new LinkedList<>();

    }

    public void put(int x) throws InterruptedException {
        sem_empty.acquire();
        number = x;
        sem_full.release();
    }

    public void put(int x, int producer_id) throws InterruptedException {
        sem_empty.acquire();
        if (mutex == null || queue == null) throw new IllegalStateException();
        mutex.acquire();
        try {
            queue.add(x);
            System.out.println("Producer " + producer_id + " produced " + x);
        }
        finally {
            mutex.release();
        }
        sem_full.release();
    }

    public int get() throws InterruptedException {
        sem_full.acquire();
        int x = 0;
        if (mutex == null || queue == null) {
            x = number;
        }
        else {
            mutex.acquire();
            try {
                x = queue.poll();
            }
            finally {
                mutex.release();
            }
        }
        sem_empty.release();
        return x;
    }


}
