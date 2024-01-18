package com.inditex.shared;

import com.inditex.price.dto.error.ErrorListMessageDTO;
import com.inditex.price.dto.error.ErrorMessageDTO;
import com.inditex.shared.exception.DomainException;
import com.inditex.shared.exception.WebException;

import com.inditex.shared.exception.InfraException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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


    @ExceptionHandler({InfraException.class, WebException.class})
    @ResponseBody
    public ResponseEntity<ErrorListMessageDTO> onComponentsExceptions(RuntimeException e) throws Exception {

        if (e instanceof InfraException) {
            if (((InfraException) e).getCode().equals("500")) {
                var errors = new ErrorListMessageDTO();
                errors.setErrors(Collections.singletonList(new ErrorMessageDTO("500", "SERVER ERROR", null, e.getMessage())));
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
            }
        }

        var errors = new ErrorListMessageDTO();
        errors.setErrors(Collections.singletonList(new ErrorMessageDTO("400", "BAD REQUEST", null, e.getMessage())));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler({DomainException.class, })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorListMessageDTO onInternalServerException(RuntimeException e) throws Exception {
        var errors = new ErrorListMessageDTO();
        errors.setErrors(Collections.singletonList(new ErrorMessageDTO("500","INTERNAL ERROR", null,e.getMessage())));
        return  errors;
    }

}