package com.example.exercise.blockthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class FutureTaskBlock {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "runable");

        new Thread(futureTask).start();

        System.out.println("阻塞主线程");
        System.out.println(futureTask.get());

        FutureTask futureTask1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                sleep(3000);
                return "callable";
            }
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask1);

        System.out.println("阻塞主线程");
        System.out.println(futureTask1.get());
        executorService.shutdown();
    }
}
