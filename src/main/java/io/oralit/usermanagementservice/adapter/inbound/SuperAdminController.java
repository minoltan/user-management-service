package io.oralit.usermanagementservice.adapter.inbound;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Minoltan Issack on 8/12/2022
 */
@RestController
@RequestMapping("/api/v1/super/admin")
public class SuperAdminController {

    @GetMapping("/")
    public String superAdminTest(){
        return "Hi I am super Admin";
    }
}
