package com.hshrigma.task_tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    String topic;
    Boolean completed;

    public Task() {
    }

    public Task(String topic, String name, String description) {
        this.topic = topic;
        this.name = name;
        this.description = description;
        completed = false;
    }

    public Task(long id, String topic, String name, String description) {
        this.id = id;
        this.topic = topic;
        this.name = name;
        this.description = description;
        completed = false;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTopic() {
        return topic;
    }

    public void setCompleted(Boolean status) {
        completed = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void resetTask(String name, String description, Boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

}
