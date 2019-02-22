package com.example.exercise.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE//类
        , ElementType.METHOD//方法
        , ElementType.FIELD//字段
         })
//运行时仍存在——反射获取
@Retention(RetentionPolicy.RUNTIME)
//可输出在文档
@Documented
//可重复注解——指定容器
@Repeatable(AnnotationContainer.class)
public @interface AnnotationDemo {
    String str() default "";
}
