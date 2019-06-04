package com.example.exercise.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.exercise.algorithm.fizzbuzz.FizzBuzzDemo;


public class ThreadDemo implements Runnable {

    private FizzBuzzDemo demo = new FizzBuzzDemo();
    private static List list = new ArrayList();
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    @Override
    public void run() {
        System.out.println(threadLocal);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ThreadDemo());
        executor.execute(new ThreadDemo());
        executor.shutdown();
    }
}
