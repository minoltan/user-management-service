package io.oralit.usermanagementservice;

import io.oralit.usermanagementservice.model.User;
import io.oralit.usermanagementservice.repository.UserRepository;
import io.oralit.usermanagementservice.resource.UserResource;
import io.oralit.usermanagementservice.service.UserManagementService;
import io.oralit.usermanagementservice.util.EmailFormatUtil;
import io.oralit.usermanagementservice.util.NumberFormatUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * @author Minoltan Issack on 8/12/2022
 */
public class UserManagementServiceTest {

    @Test
    @DisplayName("User Registration Flow. Fail if user already Exist")
    public void registerUserFailureTest(){
        UserRepository userRepository = mock(UserRepository.class);
        NumberFormatUtil numberFormatUtil = mock(NumberFormatUtil.class);
        EmailFormatUtil emailFormatUtil = mock(EmailFormatUtil.class);
        UserResource userResource = prepareUserResource();
        User user = prepareUser();

        UserManagementService userManagementService = new UserManagementService(userRepository,numberFormatUtil,emailFormatUtil);

        given(numberFormatUtil.validateMsisdnNumberPattern(userResource.getMsisdn())).willReturn(true);
        given(emailFormatUtil.validateEmailPattern(userResource.getEmail())).willReturn(true);
        given(userRepository.findByMsisdn(userResource.getMsisdn())).willReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> userManagementService.registerUser(userResource));
        verify(userRepository, never()).save(any());
    }


    private UserResource prepareUserResource(){
     return new UserResource("94719542277","Minoltan","Issack","issackpaul95@gmail.com");
    }

    private User prepareUser(){
        return new User(1L, "94719542277","Minoltan","Issack","issackpaul95@gmail.com","Test");
    }
}
