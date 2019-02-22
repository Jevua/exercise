package com.example.exercise.thread.yield;

public class YieldDemo implements Runnable{

    public static void main(String[] args) {
        YieldDemo run1 = new YieldDemo();
        YieldDemo run2 = new YieldDemo();
        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            if (i == 5) {
                System.out.println("礼让出处理器");
                Thread.yield();
            }
        }
    }
}
