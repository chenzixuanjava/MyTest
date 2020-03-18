package com.segi.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author chenzx
 * @date 2018-10-13 上午 9:28
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "用@ResponseStatus处理的异常")
public class StatusExcepiton extends RuntimeException {
    public StatusExcepiton() {
        super();
    }

    public StatusExcepiton(String message) {
        super(message);
    }
}
