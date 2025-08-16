package com.hshrigma.task_tracker.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController implements ErrorController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public ResponseEntity<Void> redirectToTasks() {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create("/api/tasks"))
                .build();
    }

    @RequestMapping("/error")
    public ResponseEntity<?> handleError() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "Resource not found",
                        "message", "The requested resource was not found",
                        "status", HttpStatus.NOT_FOUND.value(),
                        "application", appName));
    }

}