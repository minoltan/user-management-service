package io.oralit.usermanagementservice.adapter.inbound;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Minoltan Issack on 8/11/2022
 */
@Controller
public class HealthCheckController {

    @RequestMapping("/")
    @ResponseBody
    public String healthCheck(){
        return "User Management Service is up.";
    }

}
