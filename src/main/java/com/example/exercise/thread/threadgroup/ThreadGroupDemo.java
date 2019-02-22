package com.example.exercise.thread.threadgroup;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group");
        new Thread(group,()->{}).start();
        new Thread(group,()->{}).start();
        group.interrupt();
        System.out.println(group.activeCount());
    }
}
