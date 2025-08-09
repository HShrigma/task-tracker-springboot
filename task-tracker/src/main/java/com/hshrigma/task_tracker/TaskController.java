package com.hshrigma.task_tracker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.service.TaskService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("/{index}")
    public BaseTask getTask(@PathVariable int index) {
        return taskService.getTaskByIndex(index);
    }
}
