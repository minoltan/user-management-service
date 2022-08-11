package io.oralit.usermanagementservice.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Minoltan Issack on 8/11/2022
 */
@Component
public class NumberFormatUtil {
    private Pattern numberWith94Pattern;

    public NumberFormatUtil() {
        numberWith94Pattern = Pattern.compile("^[9][4][0-9]{9}$");
    }

    public boolean validateMsisdnNumberPattern(String msisdn) {
        Matcher matcher = numberWith94Pattern.matcher(msisdn);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
