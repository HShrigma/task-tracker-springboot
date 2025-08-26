package com.hshrigma.task_tracker.repo;

import com.hshrigma.task_tracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Spring Data will auto-implement this by parsing the method name
    List<Task> findByTopic(String topic);
}
