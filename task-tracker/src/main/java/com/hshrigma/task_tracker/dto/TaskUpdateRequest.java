package com.hshrigma.task_tracker.dto;

public class TaskUpdateRequest {

  String name;
  String description;
  Boolean completed;

  public Boolean getCompleted() {
    return completed;
  }


  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public void setName(String name) {
    this.name = name;
  }
}