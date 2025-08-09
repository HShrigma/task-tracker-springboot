package com.hshrigma.task_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.repo.MockTaskRepository;
import com.hshrigma.task_tracker.repo.TaskRepository;

@Service
public class TaskService {
    private final  TaskRepository tasksRepo;
    public TaskService(){
        tasksRepo = new MockTaskRepository();
    }
    public List<BaseTask> getMockTasks() {
        return tasksRepo.findAll();
    }
    public BaseTask getTaskByIndex(int index){
        return tasksRepo.getTask(index);
    }
}