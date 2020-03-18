package com.segi.javase.concurrent;

import java.util.concurrent.Executor;

/**
 * @author chenzx
 * @date 2019-06-03 下午 7:29
 */
public class DirectExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}
