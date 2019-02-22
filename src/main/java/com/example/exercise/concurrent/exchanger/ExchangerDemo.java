package com.example.exercise.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        //交换两个线程之间的值
        Exchanger<String> exchanger = new Exchanger();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                String s = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName() + "等待");
                try {
                    String temp = exchanger.exchange(s);
                    System.out.println(Thread.currentThread().getName() + "两个线程间交换所得：" + temp);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
