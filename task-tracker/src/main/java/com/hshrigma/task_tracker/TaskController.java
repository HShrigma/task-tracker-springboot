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
    ResponseEntity<?> get404(String message){
        return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "Task not found",
                            "message", message,
                            "status", HttpStatus.NOT_FOUND.value()));
    }
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTasks() {
        Optional<Map<String,List<BaseTask>>> res = Optional.ofNullable(taskService.getMockTasks());
        if(res.isPresent()){
            return ResponseEntity.ok(res.get());
        }
        return get404("No tasks found");
    }

    @GetMapping("/{topic}")
    public ResponseEntity<?> getTasksForTopic(@PathVariable String topic) {
        Optional<List<BaseTask>> res = Optional.ofNullable(taskService.getTasksForTopic(topic));
        if(res.isPresent()){
            return ResponseEntity.ok(res.get());
        }
        return get404(String.format("No tasks found for topic %s", topic));
    }

    @GetMapping("/{topic}/{id}")
    public ResponseEntity<?> getTaskByIndex(@PathVariable String topic, @PathVariable int id) {
            Optional<BaseTask> res = Optional.ofNullable(taskService.getTaskforID(topic,id));
             if (res.isPresent()) {
            return ResponseEntity.ok(res.get());
        }
        return get404(String.format("Task with ID %d does not exist for topic %s", id, topic));
        }
    }
