package com.segi.spring.task.executor.listener;

import lombok.Data;

/**
 * @author chenzx
 * @date 2018-10-19 下午 8:38
 */
@Data
public class BlackListEvent2/* extends ApplicationEvent */{
    private final String message;
    private final String content;

    public BlackListEvent2(Object source, String message, String context) {
//        super(source);
        this.message = message;
        this.content = context;
    }
}
