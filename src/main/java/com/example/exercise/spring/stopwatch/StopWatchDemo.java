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
        StopWatch sw = new StopWatch();
        sw.start("up");
        Thread.sleep(1000);
        sw.stop();
        sw.start("down");
        Thread.sleep(2000);
        sw.stop();
        sw.start("close");
        Thread.sleep(3000);
        sw.stop();
        sw.start();
        Thread.sleep(4000);
        sw.stop();
        sw.start();
        Thread.sleep(5000);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }
}
