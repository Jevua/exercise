package com.example.exercise.spring.annotation.ImportAnnotationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:@Import 将实例注入spring
 * @author jevua
 */
@Controller
@RequestMapping("ImportAnnotation.spr")
@Import(BeanDemo.class)
public class ImportAnnotationController {

    @Autowired
    private BeanDemo beanDemo;

    @RequestMapping(params = "method=importannotation")
    public void testImportAnnotation() {
        beanDemo.test();
    }
}
