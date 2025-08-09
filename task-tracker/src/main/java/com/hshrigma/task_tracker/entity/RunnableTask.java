package com.hshrigma.task_tracker.entity;

public class RunnableTask implements BaseTask {
    long id;
    String name;
    String description;
    Boolean completed;

    public RunnableTask(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        completed = false;
        run();
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
    public long getID() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void run() {
        StringBuilder message = new StringBuilder();
        message.append("Task ID: ").append(getID())
                .append("\n\tName: ").append(getName())
                .append("\n\tDescription: ").append(getDescription())
                .append("\n is running...");
        System.out.println(message.toString());
    }
}
