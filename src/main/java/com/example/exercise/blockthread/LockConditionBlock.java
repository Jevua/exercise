package com.example.exercise.blockthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockConditionBlock {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                sleep(3000);
                System.out.println("通知condition");
                condition.signal();
                lock.unlock();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        lock.lock();
        System.out.println("阻塞主线程");
        System.out.println("等待condition");
        condition.await();
        lock.unlock();
        System.out.println("继续执行主线程");
    }
}
