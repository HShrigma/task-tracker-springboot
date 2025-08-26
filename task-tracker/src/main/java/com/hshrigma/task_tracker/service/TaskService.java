
package com.hshrigma.task_tracker.service;

import com.hshrigma.task_tracker.dto.TaskPatchRequest;
import com.hshrigma.task_tracker.dto.TaskUpdateRequest;
import com.hshrigma.task_tracker.entity.Task;
import com.hshrigma.task_tracker.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    // Read
    public Optional<Task> getTaskById(Long id) {
        return repo.findById(id);
    }

    public List<Task> getByTopic(String topic) {
        return repo.findByTopic(topic);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    // Create
    public Task createTask(Task task) {
        return repo.save(task);
    }

    // Delete
    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    // Update (PUT)
    public Optional<Task> updateEntireTask(Long id, TaskUpdateRequest req) {
        return repo.findById(id).map(task -> {
            task.setName(req.getName());
            task.setDescription(req.getDescription());
            task.setCompleted(req.getCompleted());
            return repo.save(task);
        });
    }

    // Update (PATCH)
    public Optional<Task> updateOptionalTask(Long id, TaskPatchRequest updates) {
        return repo.findById(id).map(task -> {
            updates.getName().ifPresent(task::setName);
            updates.getDescription().ifPresent(task::setDescription);
            updates.getCompleted().ifPresent(task::setCompleted);
            return repo.save(task);
        });
    }
}
