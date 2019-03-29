package com.example.exercise.bitset;

import java.util.BitSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class BitSetDemo {
    public static void main(String[] args) throws InterruptedException {
        BitSet bitSet = new BitSet();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "等待");
                    cyclicBarrier.await();
                    bitSet.set(finalI);
                    System.out.println(Thread.currentThread().getName() + "释放");
                    latch.countDown();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        System.out.println(bitSet.cardinality());
        for (int i = 0; i < 4; i++) {
            System.out.println(bitSet.get(i));
        }
        if (bitSet.isEmpty()) {
            System.out.println("没有错");
        }
        else {
            int index = 0;
            while (!bitSet.isEmpty()) {
                index = bitSet.nextSetBit(index);
                System.out.println(index);
                bitSet.clear(index);
            }

        }


    }
}
