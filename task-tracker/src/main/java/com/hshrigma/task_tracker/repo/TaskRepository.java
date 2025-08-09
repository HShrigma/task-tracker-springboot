package com.hshrigma.task_tracker.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hshrigma.task_tracker.entity.BaseTask;

@Repository
public interface TaskRepository {
     public BaseTask getTaskByID(long id);
     public List<BaseTask> findAll();
}