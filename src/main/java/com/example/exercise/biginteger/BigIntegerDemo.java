package com.example.exercise.biginteger;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger integer = new BigInteger("20");
        BigInteger integer2 = new BigInteger("2");
        System.out.println(integer.add(integer2));
        System.out.println(integer.subtract(integer2));
        System.out.println(integer.multiply(integer2));
        System.out.println(integer.divide(integer2));
        System.out.println(integer.max(integer2));
        System.out.println(integer.mod(integer));
    }
}
