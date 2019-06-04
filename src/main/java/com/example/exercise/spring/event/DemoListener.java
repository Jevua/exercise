package com.example.exercise.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xzh
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("监听到：" + msg);
    }
}
