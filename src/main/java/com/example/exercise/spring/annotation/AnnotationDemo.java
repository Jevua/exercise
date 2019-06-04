package com.example.exercise.spring.annotation;

import javax.annotation.Nonnull;

public class AnnotationDemo {
    public static void main(String[] args) {
        AnnotationDemo demo = new AnnotationDemo();
        demo.testNotNull(null);
    }

    // @Nonnnull不能为空的注解
    public void testNotNull(@Nonnull String str) {
        System.out.println(str);
    }
}
