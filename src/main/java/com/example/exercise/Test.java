package com.example.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Test {

    public static void main(String[] args) throws ParseException, InterruptedException {

        Thread thread = new Thread(()->{
            System.out.println(currentThread().getName()+":sleep");
            try {
                sleep(3000);
                System.out.println(currentThread().getName()+":out");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("1");
        thread.start();
        System.out.println("2");
        sleep(1500);
        thread.start();
        System.out.println("3");

//        CountDownLatch latch = new CountDownLatch(2);
//        for (int i = 0; i < 2; i++) {
//            CountDownLatch finalLatch = latch;
//            new Thread(()->{
//                try {
//                    sleep(2000);
//                    finalLatch.countDown();
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        latch.await();
//        System.out.println("out");
//        if (2 > 0) {
//            latch = new CountDownLatch(2);
//            for (int i = 0; i < 2; i++) {
//                CountDownLatch finalLatch = latch;
//                new Thread(()->{
//                    try {
//                        sleep(2000);
//                        finalLatch.countDown();
//                    }
//                    catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }).start();
//            }
//            latch.await();
//            System.out.println("out");
//        }

    }
    private static String getLastDay(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
        Date date = null;
        try {
            date = df.parse(dateStr);
        }
        catch (ParseException e) {
        }
        df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return df.format(calendar.getTime());
    }

}
