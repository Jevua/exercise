package com.example.exercise.spring.stopwatch;

import java.util.concurrent.TimeUnit;

import org.springframework.util.StopWatch;

public class StopWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(3);
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
