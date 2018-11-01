package com.example.exercise.aspect.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.exercise.annotation.AnnotationDemo;

@Service
public class AspectService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AnnotationDemo
    public String testPointCut() {
        logger.info("do testPointCut");
        return "point ret";
    }

    public void testPointCutErr() throws Exception {
        logger.info("err testPointCut");
        throw new Exception("失败");
    }

}
