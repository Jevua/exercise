package com.example.exercise.countdownlatch;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            CountDownLatch finalLatch = latch;
            new Thread(()->{
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finalLatch.countDown();
            }).start();
        }
        System.out.println("await。。。。");
        latch.await();
        System.out.println("await out");

        latch = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            CountDownLatch finalLatch = latch;
            new Thread(()->{
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finalLatch.countDown();
            }).start();
        }

        System.out.println("await。。。。");
        latch.await();
        System.out.println("await out");

    }
}
