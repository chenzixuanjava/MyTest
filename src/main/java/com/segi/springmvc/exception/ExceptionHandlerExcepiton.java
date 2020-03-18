package com.segi.springmvc.exception;

/**
 * @author chenzx
 * @date 2018-10-13 上午 9:39
 */
public class ExceptionHandlerExcepiton extends Throwable {
    public ExceptionHandlerExcepiton() {
        super();
    }

    public ExceptionHandlerExcepiton(String message) {
        super(message);
    }
}
