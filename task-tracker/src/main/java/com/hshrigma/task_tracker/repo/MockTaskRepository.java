package com.hshrigma.task_tracker.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.entity.Task;

@Repository
public class MockTaskRepository implements TaskRepository {
    List<BaseTask> tasks;

    public MockTaskRepository() {
        this.tasks = List.of(
                new Task(1, "Clean", "Tidy up space"),
                new Task(2, "Write Code", "Implement Task Service"),
                new Task(3, "Walk Dog", "Get the dog out on a walk"),
                new Task(4, "Cook", "Make some pasta"),
                new Task(5, "Reward", "Chill out"));
    }

    @Override
    public List<BaseTask> findAll() {
        return this.tasks;
    }

    @Override
    public  BaseTask getTaskByID(long id) {
       BaseTask res = null;
       for (BaseTask baseTask : tasks) {
        if(baseTask.getID() == id){
            res = baseTask;
            break;
        }
       } 
       return res;
    }

}
