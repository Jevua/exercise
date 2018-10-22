package com.example.exercise.Synchronized;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SynchronizedDemo {

    Object lock = new Object();

    public synchronized void demo1(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        System.out.println("到达屏障点，等待其他线程到达。。。");
        cyclicBarrier.await();
        System.out.println("demo1");
    }

    public void demo2(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        synchronized (this) {
            System.out.println("到达屏障点，等待其他线程到达。。。");
            cyclicBarrier.await();
            System.out.println("demo2");
        }
    }

    public void demo3(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        synchronized (SynchronizedDemo.class) {
            System.out.println("到达屏障点，等待其他线程到达。。。");
            cyclicBarrier.await();
            System.out.println("demo3");
        }
    }

    public void demo4(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        //lock为类中的对象，，每一个实例都有一个，是实例锁。。。。2、如果是在类外声明的对象，总共只有一个，就会形成全局锁
        synchronized (lock) {
            System.out.println("到达屏障点，等待其他线程到达。。。");
            cyclicBarrier.await();
            System.out.println("demo4");
        }
    }
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        //test demo1\demo2
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    synchronizedDemo.demo2(cyclicBarrier);
//                    synchronizedDemo.demo2(cyclicBarrier);
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        //test demo3
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    SynchronizedDemo synchronizedDemo3 = new SynchronizedDemo();
                    synchronizedDemo3.demo3(cyclicBarrier);
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
