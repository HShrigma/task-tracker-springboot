package com.hshrigma.task_tracker.entity;

public class RunnableTask implements BaseTask{
    long id;
    String name;
    String description;
    Boolean status;

    public RunnableTask (long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        status = false;
    }
    
    @Override
    public Boolean GetStatus() {
        return status;
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public long GetID() {
        return id;
    }

    @Override
    public String GetDescription() {
        return description;
    }

    
    
}
