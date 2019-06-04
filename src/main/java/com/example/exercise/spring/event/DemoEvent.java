package com.example.exercise.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author xzh
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
