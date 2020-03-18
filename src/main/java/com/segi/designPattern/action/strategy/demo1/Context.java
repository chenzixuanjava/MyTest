package com.segi.designPattern.action.strategy.demo1;

import com.segi.designPattern.action.strategy.demo1.StrategyOperation;
import lombok.AllArgsConstructor;

/**
 * @author chenzx
 * @date 2018-11-26 下午 2:31
 */
@AllArgsConstructor
public class Context {
    private StrategyOperation strategyOption;

    public int executeOperation(int num1, int num2) {
        return strategyOption.doOperation(num1, num2);
    }
}
