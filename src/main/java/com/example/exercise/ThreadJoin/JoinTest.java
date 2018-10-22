package com.example.exercise.ThreadJoin;

import static java.lang.Thread.sleep;

public class JoinTest {
    public static void main(String[] args) {
        System.out.println("测试线程的join方法，thread2中执行thread.join后必须等到thread结束才能继续执行thread2");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" run..");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" run2..");
            }
        });
        thread.start();
        thread2.start();
    }
}
