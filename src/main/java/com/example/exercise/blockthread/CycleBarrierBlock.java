package com.example.exercise.blockthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

public class CycleBarrierBlock {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                try {
                    sleep(5000);
                    System.out.println("释放");
                    cyclicBarrier.await();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("阻塞主线程");
        cyclicBarrier.await();
        System.out.println("继续执行主线程");
    }
}
