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

    public List<BaseTask> getTasksByTopic(String topic) {
        return taskRepo.getByTopic(topic);
    }

    public BaseTask getTaskById( long id, String topic) {
        return taskRepo.getTaskById(id, topic);
    }

    public BaseTask createTask(String topic, String name, String description){
        return taskRepo.createTask(topic, name, description);
    }

    public BaseTask deleteTask(String topic, long id){
        return taskRepo.deleteTask(topic, id);
    }

    public BaseTask updateTask(String topic, long id, String name, String description, Boolean completed){
        return taskRepo.updateTask(topic, id, name, description, completed);
    }
}
