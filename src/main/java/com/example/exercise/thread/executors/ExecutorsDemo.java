package com.example.exercise.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {
    public static void main(String[] args) {

        //可缓存线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 索引 " + index);
                }
            });
        }

        //定长线程
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 索引 " + index);
                        Thread.sleep(2000);
//                        TimeUnit.SECONDS.sleep(2);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        //定长、定时、周期执行线程
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(()->{
            System.out.println("delay 3 seconds");
        }, 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() -> {
            System.out.println("delay 2 seconds, and excute every 3 seconds");
        }, 2, 3, TimeUnit.SECONDS);

        //单线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName() + " 索引 " + index);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
