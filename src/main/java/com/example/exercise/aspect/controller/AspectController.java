package com.example.exercise.aspect.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exercise.aspect.service.AspectService;

@Controller
@RequestMapping("aspect.spr")
public class AspectController {

    @Autowired
    private AspectService aspectService;

    @RequestMapping(
            params = {"method=do"}
    )
    public void doAspect() {
        Map map = new HashMap<>();
        map.put("key", "value");
        aspectService.testPointCut(map);
    }

    @RequestMapping(
            params = {"method=err"}
    )
    public void doErr() throws Exception {
        aspectService.testPointCutErr();
    }

}
