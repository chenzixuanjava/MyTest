package com.segi.springmvc.controller;

import com.segi.springmvc.exception.ExceptionHandlerExcepiton;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author chenzx
 * @date 2018-10-13 上午 9:57
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {ExceptionHandlerExcepiton.class})
    public String ExceptionHandler() {
        return "error";
    }
}
