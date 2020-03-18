package com.segi.shang.interview.JMM;
import java.util.concurrent.ExecutionException;
import	java.util.concurrent.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author chenzx
 * @date 2020-03-06 上午 9:47
 */
public class CallableTst {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "\tcome in");
                try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
                return 1000;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask(callable);
        FutureTask<Integer> futureTask2 = new FutureTask(callable);
        new Thread(futureTask, "t1").start();
        new Thread(futureTask2, "t2").start();

        System.out.println(Thread.currentThread().getName() +"\t 计算");
        int maindata = 100;
        while (!futureTask.isDone()) {
            System.out.println("继续等1秒");
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
        Integer integer = futureTask.get();
        System.out.println("最后结果：" + (maindata + integer));

    }
}
