package com.example.exercise.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @author jevua
 * 可重入公平的互斥锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                //可多次获得同一个锁
                lock.lock();
                System.out.println("lock " + i);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                lock.unlock();
                System.out.println("unlock " + i);
            }
        }).start();

        new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待获取锁。。");
            lock.lock();
            System.out.println("得到锁");
        }).start();

    }
}
