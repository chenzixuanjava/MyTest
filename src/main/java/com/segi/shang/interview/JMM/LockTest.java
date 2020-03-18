package com.segi.shang.interview.JMM;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenzx
 * @date 2020-03-03 上午 11:16
 */
public class LockTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        new Thread(phone, "t3").start();
        new Thread(phone, "t4").start();

    }
}

class Phone implements Runnable {

    private Lock lock = new ReentrantLock();

    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\tsendSMS");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\tsendEmail");
    }


    @Override
    public void run() {
        get();

    }

    private void get() {
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\tget");
            set();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        try{
            lock.lock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\tset");
        } finally {
//            lock.unlock();
            lock.unlock();
        }
    }
}
