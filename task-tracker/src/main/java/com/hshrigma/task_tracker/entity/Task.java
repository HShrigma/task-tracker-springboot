package com.hshrigma.task_tracker.entity;

public class Task implements BaseTask {
    long id;
    String name;
    String description;
    String topic;
    Boolean completed;

    public Task(long id, String topic, String name, String description) {
        this.id = id;
        this.topic = topic;
        this.name = name;
        this.description = description;
        completed = false;
    }

    @Override
    public Boolean getCompleted() {
        return completed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getID() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTopic() {
        return topic;
    }
}
