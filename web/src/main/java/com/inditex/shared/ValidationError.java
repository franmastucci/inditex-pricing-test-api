package com.inditex.shared;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

/**
 * The class ValidationError.
 *
 */
public class ValidationError {

    private final String code;

    private final String field;

    private final String msg;

    private final List<?> data;


    public ValidationError(String fieldName, String message) {
        this(null, fieldName, message, Collections.emptyList());
    }

}
