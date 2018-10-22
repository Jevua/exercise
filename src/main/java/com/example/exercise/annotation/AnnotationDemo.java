package com.example.exercise.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE//类
        , ElementType.METHOD//方法
        , ElementType.FIELD//字段
         })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationDemo {

    String str() default "";

}
