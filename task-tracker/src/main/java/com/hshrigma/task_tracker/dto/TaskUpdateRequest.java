package com.hshrigma.task_tracker.dto;

public class TaskUpdateRequest {
    private String name;
    private String description;
    private Boolean completed;

    public TaskUpdateRequest() {
    }

    public TaskUpdateRequest(String name, String description, Boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
