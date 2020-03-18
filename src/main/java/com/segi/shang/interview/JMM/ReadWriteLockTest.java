package com.segi.shang.interview.JMM;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenzx
 * @date 2020-03-04 上午 10:50
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }




    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t开始放入" + key);
            try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t放入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t开始获取");
            try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t获取完成" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
