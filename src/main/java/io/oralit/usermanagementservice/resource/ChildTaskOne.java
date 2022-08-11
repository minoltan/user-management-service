package io.oralit.usermanagementservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Minoltan Issack on 8/11/2022
 */
public class ChildTaskOne extends Thread{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void run(){
        for(int i=0; i<5; i++){
//            Thread.yield();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Child Task One: "+ i);
        }
    }
}
