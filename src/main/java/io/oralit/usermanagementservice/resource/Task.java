package io.oralit.usermanagementservice.resource;

import io.oralit.usermanagementservice.adapter.inbound.UserManagementController;
import io.oralit.usermanagementservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Minoltan Issack on 8/11/2022
 */
public class Task{
    private final Logger logger = LoggerFactory.getLogger(Task.class);

    private String name;
    List<Task> subTasks;
    private boolean isComplete;

    public Task(String name, List<Task> subTasks) {
        this.name = name;
        this.subTasks = subTasks;
        this.isComplete = false;
    }

    @Async
    public CompletableFuture<Task> complete() {
        logger.info("Task: " + name + " Started");
        CompletableFuture.allOf(subTasks.stream().map(Task::complete).toArray(CompletableFuture[]::new));
        this.isComplete = true;
        logger.info("Task: " + name + " completed");
        return CompletableFuture.completedFuture(this);
    }
}
