
package com.hshrigma.task_tracker.controller;

import com.hshrigma.task_tracker.dto.TaskCreateRequest;
import com.hshrigma.task_tracker.dto.TaskPatchRequest;
import com.hshrigma.task_tracker.dto.TaskUpdateRequest;
import com.hshrigma.task_tracker.entity.Task;
import com.hshrigma.task_tracker.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    // GET by topic
    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Task>> getTasksByTopic(@PathVariable String topic) {
        return ResponseEntity.ok(taskService.getByTopic(topic));
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateRequest req) {
        Task createdTask = taskService.createTask(req.toEntity());
        return ResponseEntity.created(URI.create("/api/tasks/" + createdTask.getId()))
                .body(createdTask);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskUpdateRequest req) {
        return taskService.updateEntireTask(id, req)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchUpdateTask(@PathVariable Long id, @RequestBody TaskPatchRequest req) {
        return taskService.updateOptionalTask(id, req)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
