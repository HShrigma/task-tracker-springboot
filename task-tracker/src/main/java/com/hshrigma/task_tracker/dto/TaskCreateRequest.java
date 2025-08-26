package com.hshrigma.task_tracker.dto;

import com.hshrigma.task_tracker.entity.Task;

public class TaskCreateRequest {
    private String topic;
    private String name;
    private String description;

    public TaskCreateRequest() {
    }

    public TaskCreateRequest(String topic, String name, String description) {
        this.topic = topic;
        this.name = name;
        this.description = description;
    }

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

    public Task toEntity() {
        return new Task(topic, name, description);
    }
}
