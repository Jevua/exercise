package com.example.exercise.spring.annotation.postconstruct;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author xzh
 */
@Component
public class PostConstructDemo {

    @PostConstruct
    public void init() {
        System.out.println("PostConstructDemo 构造方法执行之后，调用此方法");
    }
}
