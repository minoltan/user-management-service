package io.oralit.usermanagementservice.service;

import io.oralit.usermanagementservice.resource.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;


/**
 * @author Minoltan Issack on 8/11/2022
 */
@Service
public class SchedulerService {

    @Scheduled(cron = "0 4 10 * * ?", zone = "Asia/Colombo") // cron = "s mi h d mo dow"
    public void scheduleTask2() throws InterruptedException {
        Task task1 = new Task("sub 1", Collections.emptyList());
        Task task2 = new Task("sub 2", Collections.emptyList());

        Task task3 = new Task("task 3", Collections.emptyList());
        Task task = new Task("task 2", Arrays.asList(task1, task2));
        CompletableFuture.allOf(task.complete(), task3.complete());
    }


}
