package com.example.exercise.weblistener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;

@WebListener
public class WebListenerDemo implements ServletContextListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("===========init===========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("============destroy=========");
    }
}
