package com.inditex.shared;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

/**
 * The class ValidationErrorResponse.
 *
 */
public class ValidationErrorResponse {

    private final LocalDateTime date = LocalDateTime.now();

    private String description;

    private List<ValidationError> errors = new ArrayList<>();



    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

}