package L12;

import java.util.concurrent.CountDownLatch;

public class Consumer implements Runnable{
    private final Buffer buffer;
    private final int id;
    private final CountDownLatch countdown;

    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        if (id < 1) {
            System.out.println("Consumer ID can't be negative. Changed " + id + " to " + -id);
            id *= -1;
        }
        this.id = id;
        this.countdown = null;
    }

    public Consumer(Buffer buffer, int id, CountDownLatch countdown) {
        this.buffer = buffer;
        if (id < 1) {
            System.out.println("Consumer ID can't be negative. Changed " + id + " to " + -id);
            id *= -1;
        }
        this.id = id;
        this.countdown = countdown;
    }

    @Override
    public void run() {
        try {
            if (countdown != null) countdown.await();
            for (int i = 0; i < 100; i++) {
                try {
                    int x = buffer.get();
                    System.out.println("Consumer " + id + " started working: " + x);
                    Thread.sleep(x);
                    System.out.println("Consumer " + id + " ended working: " + x);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
