package com.example.exercise.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

//无返回值
public class RecursiveActionDemo extends RecursiveAction {

    private static final int THRESHOLD = 20;

    private int start;

    private int end;

    RecursiveActionDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + " i " + i);
            }
        }else {
            int middle = (start + end) / 2;
            RecursiveActionDemo left = new RecursiveActionDemo(start, middle);
            RecursiveActionDemo right = new RecursiveActionDemo(middle, end);
            left.fork();
            right.fork();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new RecursiveActionDemo(0, 1000));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
