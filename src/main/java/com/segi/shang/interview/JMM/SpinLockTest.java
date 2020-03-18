package com.segi.shang.interview.JMM;

import com.sun.jnlp.ApiDialog;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chenzx
 * @date 2020-03-03 下午 5:28
 */
public class SpinLockTest {

    AtomicReference<Thread> atomicReference = new AtomicReference<> ();

    private void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() +"\tcome in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    private void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() +"\tunLock");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();
        new Thread(() -> {
            spinLockTest.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockTest.unLock();
        }, "t1").start();

        new Thread(() -> {
            spinLockTest.myLock();
            spinLockTest.unLock();
        }, "t2").start();
    }
}
