package com.example.exercise.lock.reentrantreadwritelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * @author jevua
 * 可重入公平的读写锁
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        //写
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                lock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + "开始写");
                try {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "写完了");
                lock.writeLock().unlock();
            }).start();
        }


        //读
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                lock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "开始读");
                try {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "读完了");
                lock.readLock().unlock();
            }).start();
        }

        //可重入写锁
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                //可多次获得同一个锁
                lock.writeLock().lock();
                System.out.println("lock " + i);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                lock.writeLock().unlock();
                System.out.println("unlock " + i);
            }
        }).start();

        new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待获取写锁。。");
            lock.writeLock().lock();
            System.out.println("得到写锁");
        }).start();

        new Thread(()->{
            System.out.println("读线程");
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始读");
            try {
                sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读完了");
            lock.readLock().unlock();
        }).start();

        new Thread(()->{
            System.out.println("写线程");
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始写");
            try {
                sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "写完了");
            lock.writeLock().unlock();
        }).start();

        //tryLock 等待
        new Thread(()->{
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始写");
            try {
                sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "写完了");
            lock.writeLock().unlock();
        }).start();

        new Thread(()->{
            try {
                //15秒
                if (lock.writeLock().tryLock(15,TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "等待后得到锁");
                    System.out.println(Thread.currentThread().getName() + "解锁");
                    lock.writeLock().unlock();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "等待得到锁");
                sleep(4000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始写");
            try {
                sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "写完了");
            lock.writeLock().unlock();
        }).start();

        //与互斥锁一样reentrantlock
        Condition condition = lock.writeLock().newCondition();

    }
}
