package com.segi.designPattern.action.strategy.demo2;

/**
 * @author chenzx
 * @date 2018-12-10 下午 6:13
 */
public class WarnByPeriod implements Warn {
    @Override
    public void warn() {
        System.out.println("周期提醒");
    }
}
