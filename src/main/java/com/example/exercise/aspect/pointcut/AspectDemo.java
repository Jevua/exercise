package com.example.exercise.aspect.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.exercise.aspect.service.AspectService;

@Aspect
@Component
public class AspectDemo {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //类路径
//    @Pointcut("execution(* com.example.exercise.aspect.service.AspectService.*(..))")
    //注解
//    @Pointcut("@annotation(com.example.exercise.annotation.AnnotationDemo)")
//    @Pointcut("within(@org.springframework.stereotype.Controller * || @org.springframework.stereotype.Service *) && @annotation(com.example.exercise.annotation.AnnotationDemo)")
//    @Pointcut("(@within(org.springframework.stereotype.Controller) || @within(org.springframework.stereotype.Service)) && @annotation(com.example.exercise.annotation.AnnotationDemo)")
    @Pointcut("(@target(org.springframework.stereotype.Controller) || @within(org.springframework.stereotype.Service)) && @annotation(com.example.exercise.annotation.AnnotationDemo)")
    private void pointCut(){}

    @AfterReturning("pointCut()")
    public void after() {
        logger.info("point after");
    }

    @Before("pointCut()")
    public void before() {
        logger.info("point before");
    }

    @AfterThrowing("pointCut()")
    public void throwAfter() {
        logger.info("throw after");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint invocation) throws Throwable {
        logger.info("point around start");
        Object result = invocation.proceed();
        logger.info(result.toString());
        logger.info("point around end");
    }

}
