package com.inditex.shared.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.regex.Pattern;

import static com.inditex.utils.CoreConstants.*;

/**
 * The Class Name.
 */
@Value
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = false)
public class Name extends StringValueObject {

    public Name(String value) {
        super(value);

        if (value != null && !value.isEmpty()) {
            if ((value.length() > 100))
                throw new IllegalArgumentException(NAME_VALIDATION_ERROR_MSG);


            String regex = NAME_REGEX_VALIDATION;
            if(!Pattern.matches(regex, value))
                throw new IllegalArgumentException(NAME_VALIDATION_ERROR_MSG);

        }

    }

}
