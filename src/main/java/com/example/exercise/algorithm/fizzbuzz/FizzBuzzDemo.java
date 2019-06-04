package com.example.exercise.algorithm.fizzbuzz;

public class FizzBuzzDemo {

    public static void main(String[] args) {
        // 0 不知道需不需要考虑进来
        final int ZERO = 0;
        for (int i = 0; i < 50; i++) {
            int flag = 0;
            if (i % 3 == ZERO) {
                flag = flag + 3;
            }
            if (i % 5 == ZERO) {
                flag = flag + 5;
            }
            switch (flag) {
                case 0:
                    System.out.println(i);
                    break;
                case 3:
                    System.out.println("Fizz");
                    break;
                case 5:
                    System.out.println("Buzz");
                    break;
                case 8:
                    System.out.println("FizzBuzz");
                    break;
            }
        }
    }
}
