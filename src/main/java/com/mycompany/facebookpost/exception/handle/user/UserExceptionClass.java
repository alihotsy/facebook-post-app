package com.mycompany.facebookpost.exception.handle.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserExceptionClass {
    private int status;
    private String msg;
    private Boolean ok;
}
