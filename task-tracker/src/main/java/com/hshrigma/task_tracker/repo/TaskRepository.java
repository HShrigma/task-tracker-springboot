package com.hshrigma.task_tracker.repo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hshrigma.task_tracker.entity.BaseTask;

@Repository
public interface TaskRepository {
     public BaseTask getTaskById(long id, String topic);
     public List<BaseTask> getByTopic(String topic);
     public Map <String,List<BaseTask>> getAll();
}