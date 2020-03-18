package com.segi.designPattern.action.strategy.demo2;

import lombok.AllArgsConstructor;

/**
 * @author chenzx
 * @date 2018-12-10 下午 6:14
 */
@AllArgsConstructor
public class WarnService {
    private Warn warn;

    public void doWarnTask() {
        warn.warn();
    }
}
