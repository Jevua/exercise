package com.example.exercise.blockthread;

import static java.lang.Thread.sleep;

public class ThreadJoinBlock {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            try {
                sleep(5000);
                System.out.println("join线程执行完成");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        System.out.println("阻塞主线程");
        thread.join();
        System.out.println("主线程继续执行");
    }
}
