package com.example.exercise.blockthread;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class CountdownLatchBlock {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countdownLatch = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                try {
                    sleep(5000);
                    System.out.println("释放");
                    countdownLatch.countDown();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("阻塞主线程");
        countdownLatch.await();
        System.out.println("继续执行主线程");

    }
}
