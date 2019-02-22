package com.example.exercise.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jevua
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "等待");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "释放");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //屏障拦路，等待所有其他线程到达屏障点同时释放
        System.out.println("阻塞");
        cyclicBarrier.await();
        System.out.println("释放");

    }
}
