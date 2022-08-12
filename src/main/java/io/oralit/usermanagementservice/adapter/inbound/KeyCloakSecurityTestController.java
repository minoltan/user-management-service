package io.oralit.usermanagementservice.adapter.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.oralit.usermanagementservice.adapter.outbound.KeycloakClient;
import io.oralit.usermanagementservice.response.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;

/**
 * @author Minoltan Issack on 8/12/2022
 */

@RestController
@RequestMapping("/api/v1/test/keycloak")
public class KeyCloakSecurityTestController {
    @Autowired
    KeycloakClient keycloakClient;


    @GetMapping("/test/only")
    @RolesAllowed("test-only-access")
    public String getTestOnlyAccess() throws JsonProcessingException {
        return "Hi Test Only access";
    }

    @GetMapping("admin/access-token")
    public AccessTokenResponse getAdminAccessToken() throws IOException {
        return keycloakClient.getAdminAccessToken();
    }

    @GetMapping("user/access-token")
    public AccessTokenResponse getUserAccessToken() throws IOException {
        return keycloakClient.getUserAccessToken("issackpaul95@gmail.com","Mino@1120");
    }

}
