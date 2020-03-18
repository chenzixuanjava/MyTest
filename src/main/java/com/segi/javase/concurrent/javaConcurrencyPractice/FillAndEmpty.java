package com.segi.javase.concurrent.javaConcurrencyPractice;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author chenzx
 * @date 2019-11-23 下午 5:57
 */
public class FillAndEmpty {
    private final Exchanger<List> exchanger = new Exchanger<> ();
    private final List<Integer> initialEmptyData = Lists.newArrayListWithCapacity(0);
    private final List<Integer> initialFullData = Lists.newArrayList();

    class FillingLoop implements Runnable {

        @Override
        public void run() {
            List<Integer> currentData = initialEmptyData;
            try {
                while (null != currentData) {
                    addToData(currentData);
                    if (currentData.size() >= 5) {
                        currentData = exchanger.exchange(currentData);
                    }
                    System.out.println("initialEmptyData.size:" + currentData.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void addToData(List<Integer> currentData) {
            Integer add = Double.valueOf(Math.random() * 3).intValue();
            boolean added = currentData.add(add);
            System.out.println(Thread.currentThread().getName() + "：添加了：" + add);
        }
    }

    class EmptyingLoop implements Runnable {

        @Override
        public void run() {
            List<Integer> currentData = initialFullData;
            try {
                while (null != currentData) {
                    takeFromData(currentData);
                    if (CollectionUtils.isEmpty(currentData)) {
                        currentData = exchanger.exchange(currentData);
                    }
                    System.out.println("initialFullData.size:" + currentData.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void takeFromData(List<Integer> currentData) {
            if (CollectionUtils.isNotEmpty(currentData)) {
                Integer remove = Double.valueOf(Math.random() * 3).intValue();
                boolean removed= currentData.remove(remove);
                if (removed) {
                    System.out.println(Thread.currentThread().getName() + ":  移除了：" + remove);
                }
            }
        }
    }

    void start() {
        new Thread(new FillingLoop()).start();
        new Thread(new EmptyingLoop()).start();
    }

    public static void main(String[] args) {
        new FillAndEmpty().start();
    }
}
