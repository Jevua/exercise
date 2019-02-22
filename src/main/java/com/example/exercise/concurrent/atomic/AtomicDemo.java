package com.example.exercise.concurrent.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicDemo implements Runnable {

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    private String threadName;

    public AtomicDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if (atomicBoolean.compareAndSet(false, true)) {
            System.out.println(threadName + true);
            try {
//                wait(2000);
                TimeUnit.SECONDS.sleep(2);
                atomicBoolean.set(false);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(threadName + "not in");
        }
    }

    public static void main(String[] args) {
//        AtomicDemo atomicDemo = new AtomicDemo("A");
////        AtomicDemo atomicDemo1 = new AtomicDemo("B");
////        new Thread(atomicDemo).start();
////        new Thread(atomicDemo1).start();

//        AtomicInteger atomicInteger = new AtomicInteger();
//
//        System.out.println(atomicInteger.get());
//        System.out.println(atomicInteger.incrementAndGet());
//        System.out.println(atomicInteger.get());
//        System.out.println(atomicInteger.compareAndSet(0, 10));
//        atomicInteger.set(2);
//        System.out.println(atomicInteger.get());

//        AtomicLong atomicLong = new AtomicLong();
//        System.out.println(atomicLong.incrementAndGet());

//        int[] intArray = new int[]{1, 2, 3, 4, 5};
//
//        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(intArray);
//
//        System.out.println(atomicIntegerArray.addAndGet(0, 1));
//        atomicIntegerArray.compareAndSet(1, 2, 12);
//        System.out.println(atomicIntegerArray.get(1));
//        System.out.println(atomicIntegerArray.decrementAndGet(2));
//        System.out.println(atomicIntegerArray.incrementAndGet(3));

//        AtomicLongArray atomicLongArray = new AtomicLongArray(10);
//        atomicLongArray.set(0, 1);
//        atomicLongArray.lazySet(1, 3);

//        AtomicReference atomicReference = new AtomicReference();
//        Map map1 = new HashMap();
//        atomicReference.set(map1);
//
//        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(10);
//        Map map = new HashMap();
//        atomicReferenceArray.set(1, map);

        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = new AtomicReferenceFieldUpdater() {
            @Override
            public boolean compareAndSet(Object obj, Object expect, Object update) {
                return false;
            }

            @Override
            public boolean weakCompareAndSet(Object obj, Object expect, Object update) {
                return false;
            }

            @Override
            public void set(Object obj, Object newValue) {

            }

            @Override
            public void lazySet(Object obj, Object newValue) {

            }

            @Override
            public Object get(Object obj) {
                return null;
            }
        };


    }
}
