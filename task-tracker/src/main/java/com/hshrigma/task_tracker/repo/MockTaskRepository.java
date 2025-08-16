package com.hshrigma.task_tracker.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.entity.Task;

@Repository
public class MockTaskRepository implements TaskRepository {
    List<String> topics;
    Map<String, List<BaseTask>> tasks;

    public MockTaskRepository() {
        topics = List.of(
                "Home", "Work");
        List<List<BaseTask>> tempTaskValues = new ArrayList<>();
        tempTaskValues.add(List.of(
                new Task(1, topics.get(0),"Clean", "Tidy up space"),
                new Task(2, topics.get(0), "Write Code", "Implement Task Service"),
                new Task(3, topics.get(0), "Walk Dog", "Get the dog out on a walk"),
                new Task(4, topics.get(0), "Cook", "Make some pasta"),
                new Task(5, topics.get(0), "Reward", "Chill out")));
        tempTaskValues.add(List.of(
                new Task(1, topics.get(1), "Commute", "Travel to work"),
                new Task(2, topics.get(1),"Work", "Work"),
                new Task(3, topics.get(1),"Commute Back", "Travel back home")));
        tasks = new HashMap<>();

        for (int i = 0; i < topics.size(); i++) {
            tasks.put(topics.get(i), tempTaskValues.get(i));
        }
    }

    @Override
    public BaseTask getTaskById(long id, String topic) {
        if(getByTopic(topic) != null){
            for (var task : tasks.get(topic)) {
               if(task.getID() == id) 
                return task;
            }
        }
        return null;
    }

    @Override
    public List<BaseTask> getByTopic(String topic) {
        if (tasks.containsKey(topic))
            return tasks.get(topic);
        return null;
    }

    @Override
    public Map<String, List<BaseTask>> getAll() {
        if (tasks.size() > 0)
            return tasks;
        return null;
    }
}