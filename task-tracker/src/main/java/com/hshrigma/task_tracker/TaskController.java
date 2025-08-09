package com.hshrigma.task_tracker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.service.TaskService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping()
    public List<BaseTask> getTasks() {
        return taskService.getMockTasks();
    }
    
}
