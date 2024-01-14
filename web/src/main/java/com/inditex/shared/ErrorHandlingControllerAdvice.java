package com.inditex.shared;

import com.inditex.shared.exception.DomainException;
import com.inditex.shared.exception.WebException;

import com.inditex.shared.exception.InfraException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

/**
 * Handler for RestTemplate errors.
 *
 */
@ControllerAdvice
class ErrorHandlingControllerAdvice {


    @ExceptionHandler({DomainException.class, InfraException.class, WebException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onComponentsExceptions(RuntimeException e){
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.setErrors(Collections.singletonList(new ValidationError(null, e.getMessage())));
        return  error;
    }

}