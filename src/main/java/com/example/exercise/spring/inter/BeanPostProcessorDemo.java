package com.example.exercise.spring.inter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * Description：实现BeanPostProcessor，spring初始化bean前后执行
 * @author xzh
 */
@Service
public class BeanPostProcessorDemo implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " postProcessAfterInitialization");
        return bean;
    }
}
