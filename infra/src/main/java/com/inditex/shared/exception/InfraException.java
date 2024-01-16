package com.inditex.shared.exception;


import lombok.Data;

@Data
public class InfraException extends RuntimeException {

    String code;

    public InfraException(String msg, String code) {
        super(msg);
        this.code =code;

    }
}
