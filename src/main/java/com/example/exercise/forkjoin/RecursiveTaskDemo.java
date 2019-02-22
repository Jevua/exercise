package com.example.exercise.forkjoin;

import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

//有返回值
public class RecursiveTaskDemo extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 20;

    private int start;

    private int end;

    RecursiveTaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else {
            System.out.println("任务分解！！！！");
            int middle = (start + end) / 2;
            RecursiveTaskDemo left = new RecursiveTaskDemo(start, middle);
            RecursiveTaskDemo right = new RecursiveTaskDemo(middle, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new RecursiveTaskDemo(0, 1000));
        System.out.println(future.get());
        Integer integer = pool.invoke(new RecursiveTaskDemo(0, 1000));
        System.out.println(integer);
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("sum" + sum);
    }
}
