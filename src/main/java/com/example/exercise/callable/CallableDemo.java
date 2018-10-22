package com.example.exercise.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                sleep(5000);
                System.out.println("执行完成");
                return "test";
            }
        };


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> future = executorService.submit(callable);

        System.out.println(future.get());

        FutureTask<String> futureTask = new FutureTask<String>(callable);

        futureTask.run();

        //线程执行
        new Thread(futureTask).start();
        //线程池执行
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        System.out.println(futureTask.get());

        executorService.shutdown();
        executorService1.shutdown();

    }
}
