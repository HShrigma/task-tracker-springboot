package com.hshrigma.task_tracker.dto;

import java.util.Optional;

public class TaskPatchRequest {
    private Optional<String> name = Optional.empty();
    private Optional<String> description = Optional.empty();
    private Optional<Boolean> completed = Optional.empty();

    public TaskPatchRequest() {
    }

    public TaskPatchRequest(Optional<String> name, Optional<String> description, Optional<Boolean> completed) {
        this.name = name != null ? name : Optional.empty();
        this.description = description != null ? description : Optional.empty();
        this.completed = completed != null ? completed : Optional.empty();
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public Optional<Boolean> getCompleted() {
        return completed;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public void setDescription(Optional<String> description) {
        this.description = description;
    }

    public void setCompleted(Optional<Boolean> completed) {
        this.completed = completed;
    }
}
