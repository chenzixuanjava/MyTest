package com.segi.designPattern.action.observer.demo2;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenzx
 * @date 2018-12-10 下午 6:30
 */
@Data
@NoArgsConstructor
public abstract class Listener {
    private Publisher publisher;

    public Listener(Publisher publisher) {
        this.publisher = publisher;
        publisher.attachListener(this);
    }

    abstract void update();

}
