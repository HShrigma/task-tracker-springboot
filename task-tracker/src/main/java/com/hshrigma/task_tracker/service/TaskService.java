package com.hshrigma.task_tracker.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.repo.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Map<String, List<BaseTask>> getMockTasks() {
        return taskRepo.getAll();
    }

    public List<BaseTask> getTasksForTopic(String topic) {
        return taskRepo.getByTopic(topic);
    }

    public BaseTask getTaskforID(String topic, long id) {
        return taskRepo.getTaskByID(id, topic);
    }
}