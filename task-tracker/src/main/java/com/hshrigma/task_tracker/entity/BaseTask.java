package com.hshrigma.task_tracker.entity;

public interface BaseTask {
  public Boolean GetStatus();
  public String  GetName();
  public String  GetDescription();

  public long GetID();
}