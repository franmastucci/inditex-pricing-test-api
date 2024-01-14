package com.inditex.shared.exception;

import lombok.Data;

@Data
public class WebException extends RuntimeException {

    private String msg;

    public WebException(String defaultMessage) {
        this.msg = defaultMessage;
    }

}
