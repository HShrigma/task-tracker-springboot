package com.hshrigma.task_tracker.entity;

public interface BaseTask {
  public Boolean getCompleted();
  public String  getName();
  public String  getDescription();
  public String  getTopic();

  public long getID();
}