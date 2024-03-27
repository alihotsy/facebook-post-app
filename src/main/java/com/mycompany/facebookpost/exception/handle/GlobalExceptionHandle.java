package com.mycompany.facebookpost.exception.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validateFields(MethodArgumentNotValidException e) {
        Map<String,String> fieldErrors = new TreeMap<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
           String field = fieldError.getField();
           fieldErrors.put(field, fieldError.getDefaultMessage());
        });

        return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);

    }

}
