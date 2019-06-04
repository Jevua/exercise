package com.example.exercise.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jevua
 */
@Controller
@RequestMapping("event.spr")
public class EventController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(params = "method=event")
    public void test() {
        applicationContext.publishEvent(new DemoEvent(this,"test 事件"));
    }
}
