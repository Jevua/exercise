package com.example.exercise.bigdecimal;

import java.math.BigDecimal;

/**
 * @author xzh
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1);
        System.out.println(bigDecimal);
        bigDecimal = new BigDecimal(1.3);
        System.out.println(bigDecimal);
        bigDecimal = new BigDecimal("1.3");
        System.out.println(bigDecimal);
        bigDecimal = BigDecimal.valueOf(1.3);
        System.out.println(bigDecimal);
    }


}
