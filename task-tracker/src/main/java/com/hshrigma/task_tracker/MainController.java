package com.hshrigma.task_tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String index(){
        System.out.println("appName is: " + appName);
        return "index.html";
    }
}