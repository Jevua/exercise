package com.example.exercise.spring.inter;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * Description：实现BeanFactoryPostProcessor，spring初始化bean前执行可对bean的定义进行修改
 * @author xzh
 */
@Service
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("initializingBeanDemo");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("name", "test");
        System.out.println("BeanFactoryPostProcessorDemo do:\n" + beanDefinition.getBeanClassName() + " " + beanDefinition.isSingleton());
    }
}
