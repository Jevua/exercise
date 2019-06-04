package com.example.exercise.spring.inter;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

/**
 * Description：实现DisposableBean，spring销毁bean前执行
 * @author xzh
 */
@Service
public class DisposableBeanDemo implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBeanDemo bean 销毁前执行");
    }
}
