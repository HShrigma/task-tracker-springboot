package com.hshrigma.task_tracker.dto;

public class TaskCreateRequest {
    String topic;
    String name;
    String description;

    public String getTopic() {
        return topic;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}