package com.example.exercise.algorithm.orderedoutput;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// 通过N个线程顺序循环打印从0至100
public class SoutSortNum {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger val = new AtomicInteger(0);
        int num = 3;
        Thread[] threads = new Thread[num];
        Semaphore[] semaphores = new Semaphore[num];
        for (int i = 0; i < num; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != num - 1) {
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < num; i++) {
            Semaphore pre = i == 0 ? semaphores[num - 1] : semaphores[i - 1];
            Semaphore next = semaphores[i];
            int index = i;
            threads[i] = new Thread(()->{
                while (val.get() <= 100) {
                    try {
                        pre.acquire();
                        if (val.get() <= 100) {
                            System.out.println("thread" + index + ": " + val.getAndIncrement());
                        }
                        next.release();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }
}
