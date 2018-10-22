package com.example.exercise.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockConditionDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        for (int i = 0; i < 5; i++) {
            int x = i + 1;
            new Thread(()->{
                try {
                    sleep(3000 * x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "unlock");
            }).start();
        }

        new Thread(()->{
           lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁");
            try {
                System.out.println("condition wait in and unlock");
                condition.await();
                System.out.println("condition wait out");
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "unlock");
        }).start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁");
            condition.signal();
            System.out.println("condition signal");
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "unlock");
        }).start();


    }



}
