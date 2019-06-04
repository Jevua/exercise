package com.example.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exercise.spring.annotation.ImportAnnotationDemo.BeanDemo;
import com.example.exercise.spring.inter.InitializingBeanDemo;

/**
 * @author jevua
 */
@Controller
@RequestMapping("exercise.spr")
public class ExerciseController {

    @RequestMapping(params = "method=test")
    public void test() {

    }
}
