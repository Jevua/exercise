package com.example.exercise.concurrent.semaphore;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * @author jevua
 * 信号量，得到与释放
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2,true);

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "得到信号");
                    sleep(2000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放信号");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
