package com.hshrigma.task_tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.entity.RunnableTask;

@Service
public class TaskService {
    public List<BaseTask> getMockTasks() {
        List<BaseTask> tasks = new ArrayList<>();
        tasks.add(new RunnableTask(1, "Clean", "Tidy up space"));
        tasks.add(new RunnableTask(2, "Write Code", "Implement Task Service"));
        tasks.add(new RunnableTask(3, "Walk Dog", "Get the dog out on a walk"));
        tasks.add(new RunnableTask(4, "Cook", "Make some pasta"));
        tasks.add(new RunnableTask(5, "Reward", "Chill out"));
        return tasks;
    }
}
