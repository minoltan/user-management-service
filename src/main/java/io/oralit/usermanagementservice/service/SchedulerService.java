package io.oralit.usermanagementservice.service;

import io.oralit.usermanagementservice.model.User;
import io.oralit.usermanagementservice.repository.UserRepository;
import io.oralit.usermanagementservice.resource.TaskCallerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.concurrent.CompletableFuture;


/**
 * @author Minoltan Issack on 8/11/2022
 */
@Service
public class SchedulerService {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    TaskCallerService taskCallerService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Multi threading Completable Future
    public ResponseEntity getUsers(){
        CompletableFuture<List<User>> users1=userManagementService.findAllUsers();
        CompletableFuture<List<User>> users2=userManagementService.findAllUsers();
        CompletableFuture<List<User>> users3=userManagementService.findAllUsers();
        CompletableFuture.allOf(users1,users2,users3).join(); // all method will wait until finish the execution of each task
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    @Scheduled(cron = "0 46 23 * * ?", zone = "Asia/Colombo") // cron = "s mi h d mo dow"
    public void scheduleTask() throws InterruptedException {
        taskCallerService.callTask();
    }


}
