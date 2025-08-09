package com.hshrigma.task_tracker;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MainController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("")
   public ResponseEntity<Void> redirectToTasks() {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                           .location(URI.create("/tasks"))
                           .build();
    }

    @GetMapping("/error")
    public ResponseEntity<?> requestMethodName() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", "Page not Found",
                        "message", "The requested path does not exist",
                        "status", HttpStatus.NOT_FOUND.value()));
    }

}