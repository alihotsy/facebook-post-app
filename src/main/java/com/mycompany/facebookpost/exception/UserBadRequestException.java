package com.mycompany.facebookpost.exception;

import lombok.Getter;

@Getter
public class UserBadRequestException extends RuntimeException{
    private final String msg;
    public UserBadRequestException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
