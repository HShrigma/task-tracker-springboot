package com.hshrigma.task_tracker.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.entity.RunnableTask;

@Repository
public class MockTaskRepository implements TaskRepository {
    List<BaseTask> tasks;

    public MockTaskRepository() {
        this.tasks = List.of(
                new RunnableTask(1, "Clean", "Tidy up space"),
                new RunnableTask(2, "Write Code", "Implement Task Service"),
                new RunnableTask(3, "Walk Dog", "Get the dog out on a walk"),
                new RunnableTask(4, "Cook", "Make some pasta"),
                new RunnableTask(5, "Reward", "Chill out"));
    }

    @Override
    public List<BaseTask> findAll() {
        return this.tasks;
    }

    @Override
    public BaseTask getTask(int index) {
        return tasks.get(index);
    }
}
