package com.segi.spring.task.executor.listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * @author chenzx
 * @date 2018-10-19 下午 8:38
 */
@Data
public class BlackListEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
    private final String message;
    private final String content;

    public BlackListEvent(Object source, String message, String context) {
        super(source);
        this.message = message;
        this.content = context;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forType(getClass(), ResolvableType.forInstance(getSource()));
    }
}
