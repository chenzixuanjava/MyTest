package com.segi.javase.concurrent.javaConcurrencyPractice;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chenzx
 * @date 2019-11-23 下午 4:43
 */
public class Solver {
    private final Integer[][] data;
    private final int rowNum;
    private final CyclicBarrier barrier;

    public Solver(Integer[][] data) {
        this.data = data;
        this.rowNum = data.length;
        this.barrier = new CyclicBarrier(rowNum, new Runnable() {
            @Override
            public void run() {
                mergeRows();
            }
        });

        List<Thread> threads = Lists.newArrayList();
        for (int i = 0; i < rowNum; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }
    }

    private void mergeRows() {
        System.out.println(Thread.currentThread().getName() + "：所有数组都解决完毕！data:");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    class Worker implements Runnable {
        private final Integer rowNum;
        private boolean done = false;

        public Worker(Integer rowNum) {
            this.rowNum = rowNum;
        }

        @Override
        public void run() {
            while (!done()) {
                processRow(rowNum);
                try {
                    int index = barrier.await();
                    System.out.println(Thread.currentThread().getName()+ "：Worker+" + index + "执行任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        private void processRow(Integer rowNum) {
            Integer[] rowData = data[rowNum];
            for (int i = 0; i < rowData.length; i++) {
                rowData[i] = rowData[i] * 2;
            }
            done = true;
        }

        private boolean done() {
            return done;
        }
    }

    public static void main(String[] args) {
        new Solver(new Integer[][]{{1,2,3},{4,5,6}});
    }
}
