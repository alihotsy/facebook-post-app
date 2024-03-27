package com.mycompany.facebookpost.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException{
    private String msg;
    public UserNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
