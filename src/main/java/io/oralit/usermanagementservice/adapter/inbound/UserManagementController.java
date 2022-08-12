package io.oralit.usermanagementservice.adapter.inbound;

import io.oralit.usermanagementservice.resource.UserResource;
import io.oralit.usermanagementservice.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Minoltan Issack on 8/11/2022
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserManagementController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserManagementService userManagementService;


    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserResource userResource){
        logger.info("request - registerUser | (URL - /api/v1/user/register)");
        userManagementService.registerUser(userResource);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getAllRegisteredUsers(){
        logger.info("request - getAllRegisteredUsers | (URL - /api/v1/user/list)");
        ResponseEntity<Object> responseEntity = sendSuccessResponse(userManagementService.getAllRegisteredUsers());
        logger.info("response - getAllRegisteredUsers | (URL - /api/v1/user/list | Response = {})", responseEntity);
        return responseEntity;
    }

}
