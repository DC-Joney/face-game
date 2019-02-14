package com.face.gmail.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ManageExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletResponse response){
        return "UNSUCCESS";
    }

}
