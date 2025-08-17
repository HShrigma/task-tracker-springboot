package com.hshrigma.task_tracker.repo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hshrigma.task_tracker.entity.BaseTask;

@Repository
public interface TaskRepository {
     // Read
     public BaseTask getTaskById(long id, String topic);
     public List<BaseTask> getByTopic(String topic);
     public Map <String,List<BaseTask>> getAll();

     // Create
     public BaseTask createTask(String topic, String name, String description);

     // Delete
     public BaseTask deleteTask(String topic, long id);

     // Update
     public BaseTask updateTask(String topic, long id, String name, String description, Boolean completed);
     public BaseTask updateTaskName(String topic, long id, String name);
     public BaseTask updateTaskDescription(String topic, long id, String description);
     public BaseTask updateTaskCompletion(String topic, long id, Boolean completed);
}
