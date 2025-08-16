package com.hshrigma.task_tracker.controller;

import com.hshrigma.task_tracker.dto.TaskCreateRequest;
import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<BaseTask>>> getAllTasks() {
        return ResponseEntity.ok(taskService.getMockTasks());
    }

    @GetMapping("/{topic}")
    public ResponseEntity<List<BaseTask>> getTasksByTopic(@PathVariable String topic) {
        List<BaseTask> tasks = taskService.getTasksByTopic(topic);
        return tasks != null ? ResponseEntity.ok(tasks) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{topic}/{id}")
    public ResponseEntity<BaseTask> getTaskById(
            @PathVariable String topic,
            @PathVariable long id) {
        BaseTask task = taskService.getTaskById(id, topic);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<BaseTask> createTask(@RequestBody TaskCreateRequest req) {
        BaseTask createdTask = taskService.createTask(req.topic, req.name, req.description);

        return createdTask != null
                ? ResponseEntity.created(URI.create("/api/tasks/" + req.topic + "/" + createdTask.getId()))
                                .body(createdTask)
                : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{topic}/{id}")
    public ResponseEntity<BaseTask> deleteTask(@PathVariable String topic, @PathVariable long id) {
        BaseTask toRemove = taskService.deleteTask(topic, id);
        return toRemove != null ? ResponseEntity.ok(toRemove) : ResponseEntity.notFound().build();
    }
}