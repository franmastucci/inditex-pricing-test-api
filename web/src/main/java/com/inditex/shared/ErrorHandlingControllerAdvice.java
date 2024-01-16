package com.inditex.shared;

import com.inditex.price.dto.error.ErrorListMessageDTO;
import com.inditex.price.dto.error.ErrorMessageDTO;
import com.inditex.shared.exception.DomainException;
import com.inditex.shared.exception.InternalServerException;
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


    @ExceptionHandler({InfraException.class, WebException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorListMessageDTO onComponentsExceptions(RuntimeException e) throws Exception {

        if (e instanceof InfraException) {
            if(((InfraException) e).getCode().equals("500"))
                throw new InternalServerException(e.getMessage());
        }

        var errors = new ErrorListMessageDTO();
        errors.setErrors(Collections.singletonList(new ErrorMessageDTO("400","BAD REQUEST", null,e.getMessage())));
        return  errors;
    }


    @ExceptionHandler({InternalServerException.class, DomainException.class, })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorListMessageDTO onInternalServerException(RuntimeException e) throws Exception {
        var errors = new ErrorListMessageDTO();
        errors.setErrors(Collections.singletonList(new ErrorMessageDTO("500","INTERNAL ERROR", null,e.getMessage())));
        return  errors;
    }

}