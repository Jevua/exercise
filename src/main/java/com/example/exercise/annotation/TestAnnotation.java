package com.example.exercise.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@AnnotationDemo(str = "type")
public class TestAnnotation {

    @AnnotationDemo(str = "field")
    private String str;


    @AnnotationDemo(str = "method")
    public void demo() {
        System.out.println("demo");
    }

    public static void main(String[] args) {

        TestAnnotation testAnnotation = new TestAnnotation();

        Class<?> clazz = testAnnotation.getClass();
        if (clazz.isAnnotationPresent(AnnotationDemo.class)) {
            AnnotationDemo annotationDemo = clazz.getAnnotation(AnnotationDemo.class);
            System.out.println(annotationDemo.str());
        }
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            if (f.isAnnotationPresent(AnnotationDemo.class) == true) {
                AnnotationDemo annotationDemo = f.getAnnotation(AnnotationDemo.class);
                System.out.println(annotationDemo.str());
            }
        }
        Method[] method = clazz.getDeclaredMethods();
        for (Method m : method) {
            if (m.isAnnotationPresent(AnnotationDemo.class)) {
                AnnotationDemo annotationDemo = m.getAnnotation(AnnotationDemo.class);
                System.out.println(annotationDemo.str());
            }
        }
    }
}
