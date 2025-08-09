package com.hshrigma.task_tracker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hshrigma.task_tracker.entity.BaseTask;
import com.hshrigma.task_tracker.service.TaskService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public List<BaseTask> getTasks() {
        return taskService.getMockTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskByIndex(@PathVariable int id) {
            Optional<BaseTask> res = Optional.ofNullable(taskService.getTaskByID(id));
             if (res.isPresent()) {
            return ResponseEntity.ok(res.get());
        } else {
            // Return 404 Not Found with a meaningful message
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "Task not found",
                            "message", String.format("Task with ID %d does not exist", id),
                            "status", HttpStatus.NOT_FOUND.value()));
        }
    }

}