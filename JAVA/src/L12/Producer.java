package L12;

import java.util.Random;

public class Producer implements Runnable{
    private final int id;
    private final Buffer buffer;
    private final Random random;


    public Producer(Buffer buffer) {
        this.buffer = buffer;
        this.random = new Random();
        this.id = -1;
    }

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.random = new Random();
        if (id < 1) {
            System.out.println("Producer ID can't be negative. Changed " + id + " to " + -id);
            id *= -1;
        }
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(4501) + 500;
            try {
                if (id == -1) {
                    buffer.put(x);
                }
                else {
                    buffer.put(x, id);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
