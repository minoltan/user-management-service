package io.oralit.usermanagementservice.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Minoltan Issack on 8/11/2022
 */
@Component
public class EmailFormatUtil {
    private Pattern emailPattern;

    public EmailFormatUtil() {
        emailPattern = Pattern.compile("^(.+)@(.+)$");
    }

    public boolean validateEmailPattern(String msisdn) {
        Matcher matcher = emailPattern.matcher(msisdn);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
