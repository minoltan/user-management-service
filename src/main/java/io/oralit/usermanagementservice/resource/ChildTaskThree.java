package io.oralit.usermanagementservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Minoltan Issack on 8/11/2022
 */
public class ChildTaskThree implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Child Task Three: "+ i);
        }
    }
}
