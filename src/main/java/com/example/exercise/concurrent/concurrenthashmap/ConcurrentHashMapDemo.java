package com.example.exercise.concurrent.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                concurrentHashMap.put(i, i);
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println(concurrentHashMap.get(i));
            }
        }).start();
    }
}
