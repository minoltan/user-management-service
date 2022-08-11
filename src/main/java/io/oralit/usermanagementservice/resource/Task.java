package io.oralit.usermanagementservice.resource;

import io.oralit.usermanagementservice.model.User;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Minoltan Issack on 8/11/2022
 */
public class Task extends Thread{
    private String name;
    List<Task> subTask;

    @Async
    public CompletableFuture<List<Task>> findAllUsers(){
        List<CompletableFuture> taskList = new ArrayList<>();
        for(int i=0; i<subTask.size(); i++){
            CompletableFuture<Task> users1= CompletableFuture.completedFuture(subTask.get(i));
            taskList.add(users1);
        }
        for(int i=0; i<taskList.size(); i++){
            CompletableFuture.allOf(taskList.get(i));
        }
       return null;

    }
}
