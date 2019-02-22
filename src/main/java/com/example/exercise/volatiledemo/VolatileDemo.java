package com.example.exercise.volatiledemo;

public class VolatileDemo {
    //加上volatile后线程可以实时获取到主线程中flag的变化，否则线程会无限循环
    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            int i = 0;
            while (!flag) {
                i++;
                System.out.println(i);
            }
        });
        t.start();
        System.out.println("start");
        t.sleep(2000);
        flag = true;
    }

}
