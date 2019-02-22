package com.example.exercise.concurrent.concurrentlinkedqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue();
        for (int i = 0; i < 20; i++) {
            linkedQueue.add(i);
        }

        //判空
        System.out.println(linkedQueue.isEmpty());
        //获取头元素，不移除
        System.out.println(linkedQueue.peek());
        //获取头元素，移除
        System.out.println(linkedQueue.poll());
        System.out.println(linkedQueue.peek());
        System.out.println(linkedQueue.peek());
    }
}
