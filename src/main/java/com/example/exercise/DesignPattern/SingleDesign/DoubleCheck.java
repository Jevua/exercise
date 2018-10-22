package com.example.exercise.DesignPattern.SingleDesign;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

    public class DoubleCheck implements Serializable {
        private volatile static DoubleCheck singleClass;
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        private DoubleCheck() {
        }

        public static DoubleCheck getSingleClass(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
            if (singleClass == null) {
                String name = Thread.currentThread().getName();
                System.out.println(name+"判断为空，等待！！！！");
                cyclicBarrier.await();
                int t = new Random().nextInt(1000);
                sleep(t);
                System.out.println(name + singleClass + "时间" + t);
                synchronized (DoubleCheck.class) {
                    System.out.println(name+"加锁");
                    if (singleClass == null) {
                        singleClass = new DoubleCheck();
                    }
                }
            }
            return singleClass;
        }

        public static void main(String[] args) {

            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
            for (int i = 0; i < 10; i++) {
                cachedThreadPool.execute(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DoubleCheck singleClass = null;
                        try {
                            singleClass = DoubleCheck.getSingleClass(cyclicBarrier);
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + singleClass);
                    }
                }));
            }

//        SingleClass singleClass = SingleClass.getSingleClass();
//        SingleClass singleClass2 = SingleClass.getSingleClass();
//        System.out.println(singleClass);
//        System.out.println(singleClass2);
//
//        singleClass.setContent("序列化test");

        }


    }
