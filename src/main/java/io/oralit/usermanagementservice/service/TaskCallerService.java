package io.oralit.usermanagementservice.service;


import io.oralit.usermanagementservice.resource.ChildTaskOne;
import io.oralit.usermanagementservice.resource.ChildTaskThree;
import io.oralit.usermanagementservice.resource.ChildTaskTwo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Minoltan Issack on 8/11/2022
 */
@Service
public class TaskCallerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void callTask() throws InterruptedException {
        // Extend Thread
        ChildTaskOne childTaskOne = new ChildTaskOne();
        childTaskOne.start();
        childTaskOne.join();

        ChildTaskTwo childTaskTwo = new ChildTaskTwo();
        childTaskTwo.start();
        childTaskTwo.join();

        // Use runnable interface
        Runnable childTaskThree = new ChildTaskThree();
        Thread runnableTask = new Thread(childTaskThree);
        runnableTask.start();
        runnableTask.join();


        // Define anonymous class
        Runnable lambda = () -> {
            for(int i=0; i<5; i++){
                logger.info("Waiting Anonymous class Task: "+ i);
            }
        };
        Thread lambdaTask = new Thread(lambda);
        lambdaTask.start();

        logger.info("Waiting Main Task");
    }
}
