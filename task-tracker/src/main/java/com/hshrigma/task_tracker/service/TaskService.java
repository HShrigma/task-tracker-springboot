package com.hshrigma.task_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.repo.TaskRepository;

@Service
public class TaskService {
    private final  TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }
    public List<BaseTask> getMockTasks() {
        return taskRepo.findAll();
    }
    
    public BaseTask getTaskByID(int id){
        return taskRepo.getTaskByID(id);
    }
}