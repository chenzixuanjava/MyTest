package com.segi.designPattern.action.strategy.demo1;

/**
 * @author chenzx
 * @date 2018-11-26 下午 2:35
 */
public class StrategyOperationMul implements StrategyOperation{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
