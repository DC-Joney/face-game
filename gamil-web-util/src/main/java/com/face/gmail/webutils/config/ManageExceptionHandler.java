package com.face.gmail.webutils.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@RestController
@ControllerAdvice
public class ManageExceptionHandler {


    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletResponse response){
        log.info(e);
        return "UNSUCCESS";
    }

}
