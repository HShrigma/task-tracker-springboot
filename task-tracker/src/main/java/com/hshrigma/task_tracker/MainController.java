package com.hshrigma.task_tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.service.TaskService;

@Controller
public class MainController {
    @Value("${spring.application.name}")
    String appName;

    private final TaskService taskService;
    public MainController(TaskService taskService){
        this.taskService = taskService;
    }
    

    @RequestMapping("/")
    public String index(){
        System.out.println("appName is: " + appName);
        List<BaseTask> tasks = taskService.getMockTasks();
        for( var task : tasks){
            System.out.println("[INFO] " + task.GetName() + " - " + task.GetDescription());
        }

        return "index.html";
    }
    
}