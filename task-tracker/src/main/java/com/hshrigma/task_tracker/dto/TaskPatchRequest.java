package com.hshrigma.task_tracker.dto;

import java.util.Optional;

public class TaskPatchRequest {
   public  Optional<String> name = Optional.empty();
   public  Optional<String> description = Optional.empty();
   public  Optional<Boolean> completed = Optional.empty();
}
