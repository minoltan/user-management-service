package io.oralit.usermanagementservice.service;

import io.oralit.usermanagementservice.exception.BadRequestException;
import io.oralit.usermanagementservice.exception.ConflictException;
import io.oralit.usermanagementservice.model.User;
import io.oralit.usermanagementservice.repository.UserRepository;
import io.oralit.usermanagementservice.resource.UserResource;
import io.oralit.usermanagementservice.util.EmailFormatUtil;
import io.oralit.usermanagementservice.util.NumberFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Minoltan Issack on 8/11/2022
 */

@Service
public class UserManagementService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;
    private final NumberFormatUtil numberFormatUtil;
    private final EmailFormatUtil emailFormatUtil;

    @Autowired
    public UserManagementService(UserRepository userRepository, NumberFormatUtil numberFormatUtil, EmailFormatUtil emailFormatUtil) {
        this.userRepository = userRepository;
        this.numberFormatUtil = numberFormatUtil;
        this.emailFormatUtil = emailFormatUtil;
    }


    public void registerUser(UserResource userResource) {
        if (numberFormatUtil.validateMsisdnNumberPattern(userResource.getMsisdn())) {
            if (emailFormatUtil.validateEmailPattern(userResource.getEmail())) {
                if (userRepository.findByMsisdn(userResource.getMsisdn()).isEmpty()) {
                    User user = new User();
                    BeanUtils.copyProperties(userResource, user); // can use set or constructor if the source and target has different values
                    userRepository.save(user);
                } else {
                    throw new ConflictException("User Already exist for this mobile number");
                }
            } else {
                throw new BadRequestException("Email format is invalid");
            }
        } else {
            throw new BadRequestException("Mobile number format is invalid");
        }


    }

    public List<UserResource> getAllRegisteredUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> new UserResource(user.getMsisdn(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword())).collect(Collectors.toList());
    }

    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("get list of user by "+Thread.currentThread().getName());
        List<User> users=userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }

}
