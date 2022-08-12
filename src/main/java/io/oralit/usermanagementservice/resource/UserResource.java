package io.oralit.usermanagementservice.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author Minoltan Issack on 8/11/2022
 */
@Data
@AllArgsConstructor
public class UserResource {
    private String msisdn;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
}
