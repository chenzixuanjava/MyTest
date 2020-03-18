package com.segi.javase.concurrent;

import java.util.concurrent.Executor;

/**
 * @author chenzx
 * @date 2019-06-03 下午 7:35
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}
