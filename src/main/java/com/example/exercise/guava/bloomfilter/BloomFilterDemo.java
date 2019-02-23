package com.example.exercise.guava.bloomfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterDemo {
    public static void main(String[] args) {
        //存入一百万数据
        int size = 1000000;

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.04);

        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        for (int i = 0; i < size; i++) {
            if (!bloomFilter.mightContain(i)) {
                System.out.println("真实存在的数据未检测到：" + i);
            }
        }

        List<Integer> list = new ArrayList<>();

        Random ra =new Random();
        int random = (ra.nextInt(10) + 1) * 10000;

        for (int i = size; i < size + random; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }

        double sum = list.size();

        System.out.println("误判的概率：" + sum / random);

    }
}
