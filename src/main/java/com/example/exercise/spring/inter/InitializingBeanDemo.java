package com.example.exercise.spring.inter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Description：实现InitializingBean，spring创建bean后判断执行
 * @author xzh
 */
@Service
public class InitializingBeanDemo implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanDemo bean 初始化后调用");
        System.out.println("BeanFactoryPostProcessorDemo:"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
