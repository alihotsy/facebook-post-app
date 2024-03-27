package com.mycompany.facebookpost.exception.handle.user;

import com.mycompany.facebookpost.exception.UserBadRequestException;
import com.mycompany.facebookpost.exception.UserNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleUserException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserExceptionClass> userNotFound(UserNotFoundException err) {
        UserExceptionClass userExceptionClass = new UserExceptionClass(404,err.getMsg(),false);
        return new ResponseEntity<>(userExceptionClass, HttpStatusCode.valueOf(userExceptionClass.getStatus()));
    }

    @ExceptionHandler(UserBadRequestException.class)
    public ResponseEntity<UserExceptionClass> badRequest(UserBadRequestException err) {
        UserExceptionClass userExceptionClass = new UserExceptionClass(400, err.getMsg(),false);
        return new ResponseEntity<>(userExceptionClass, HttpStatusCode.valueOf(userExceptionClass.getStatus()));
    }

}
