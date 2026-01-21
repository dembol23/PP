package L12;

import java.util.concurrent.CountDownLatch;

public class Main {
    static void main() {
//        zad1();
        zad2();
    }

    static void zad1() {
        Buffer buffer = new Buffer();
        CountDownLatch countdown = new CountDownLatch(1);
        new Thread(new Producer(buffer)).start();
        Thread t1 = new Thread(new Consumer(buffer, 1, countdown));
        Thread t2 = new Thread(new Consumer(buffer, 2, countdown));
        Thread t3 = new Thread(new Consumer(buffer, 3, countdown));
        t1.start();
        t2.start();
        t3.start();
        countdown.countDown();
    }

    static void zad2() {
        Buffer buffer = new Buffer(10);

        for (int i = 1; i <= 3; i++) {
            new Thread(new Producer(buffer, i)).start();
        }

        for (int i = 1; i <= 4; i++) {
            new Thread(new Consumer(buffer, i)).start();
        }
    }
}