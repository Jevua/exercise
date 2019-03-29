package com.example.exercise.thread.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import static java.lang.Thread.sleep;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 核心线程数
        int corePoolSize = 4;
        // 最大线程数
        int maximumPoolSize = 6;
        // 保持活跃时间
        long keepAliveTime = 60L;
        // 活跃时间的单位
        TimeUnit unit = TimeUnit.SECONDS;
        // 工作队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(3);
        // 线程工厂
        ThreadFactory threadFactory = new CustomizableThreadFactory();
        // 拒绝策略
        RejectedExecutionHandler handler;
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

        // 首先判断核心线程数，小于直接启动，大于则判断工作队列，工作队列未满，添加到队列，否则判断，最大线程数，小于则直接启动，大于调用拒绝策略
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            executorService.execute(new Thread(() -> {
                try {
                    sleep(100000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }

    }
}
