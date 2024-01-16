package com.inditex.shared.exception;

import lombok.Data;

@Data
public class InternalServerException extends RuntimeException {

    private String msg;

    public InternalServerException(String defaultMessage) {
        this.msg = defaultMessage;
    }

}



