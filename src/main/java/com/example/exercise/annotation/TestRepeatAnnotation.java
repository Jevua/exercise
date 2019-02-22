package com.example.exercise.annotation;

import java.util.Arrays;

@AnnotationDemo(str = "1")
@AnnotationDemo(str = "2")
@AnnotationDemo(str = "3")
public class TestRepeatAnnotation {

    public static void main(String[] args) {
//        TestRepeatAnnotation t = new TestRepeatAnnotation();
//        Class<?> clazz = t.getClass();
        Class<TestRepeatAnnotation> clazz = TestRepeatAnnotation.class;
        AnnotationDemo[] annotationDemo = clazz.getAnnotationsByType(AnnotationDemo.class);
        for (AnnotationDemo demo : annotationDemo) {
            System.out.println(demo.str());
        }
        Arrays.stream(annotationDemo)
                .forEach(System.out::println);
    }
}
