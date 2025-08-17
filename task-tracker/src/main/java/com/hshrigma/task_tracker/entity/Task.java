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
    public long getId() {
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

    @Override
    public void setCompleted(Boolean status) {
        completed = status;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public void resetTask(String name, String description, Boolean completed){
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

}
