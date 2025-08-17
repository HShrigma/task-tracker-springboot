package com.hshrigma.task_tracker.entity;

public interface BaseTask {
  // Read
  public Boolean getCompleted();
  public String  getName();
  public String  getDescription();
  public String  getTopic();
  public long getId();

  // Write
  public void setCompleted(Boolean status);
  public void setName(String name);
  public void setDescription(String description);
  public void setTopic(String topic);
  public void setId(long id);
  public void resetTask(String name, String description, Boolean completed);
}