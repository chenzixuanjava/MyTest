package com.segi.shang.interview.JMM;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chenzx
 * @date 2020-02-29 下午 5:19
 */
public class CASDemo {


    public static void main(String[] args) {
        /*AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 100) + "\tvalue:\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\tvalue:\t" + atomicInteger.get());*/
//        AtomicReference<User> atomicReference = new AtomicReference<>();
//        AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
        AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(100, 1);
//        AtomicInteger counter = new AtomicInteger(100);
        /*User zs = new User("zs", 23);
        User ls = new User("ls", 26);
        atomicReference.set(zs);*/
        /*System.out.println(atomicReference.compareAndSet(zs, ls) + "\tuser:" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(zs, ls) + "\tuser:" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(ls, zs) + "\tuser:" + atomicReference.get());*/

        new Thread(() -> {
            int stamp = atomicReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第一次的版本号是：" + stamp);
//            System.out.println(atomicReference.compareAndSet(zs, ls) + "\t" + Thread.currentThread().getName() + "\tuser:" + atomicReference.get())
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 101, stamp, stamp + 1) + "\t" + Thread.currentThread().getName() + "\t第二次的版本号是：" + atomicReference.getStamp());
            System.out.println(atomicReference.compareAndSet(101, 100, atomicReference.getStamp(), atomicReference.getStamp() + 1) + "\t" + Thread.currentThread().getName() + "\t第三次的版本号是：" + atomicReference.getStamp());

        }, "t1").start();

        new Thread(() -> {
            int stamp = atomicReference.getStamp();
//            System.out.println(atomicReference.compareAndSet(zs, ls) + "\t" + Thread.currentThread().getName() + "\tuser:" + atomicReference.get())
            System.out.println(Thread.currentThread().getName() + "\t第一次的版本号是：" + stamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2020, stamp, stamp + 1) + "\t" + Thread.currentThread().getName() + "\t第二次的版本号是：" + atomicReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "result: " + atomicReference.getReference());

        }, "t2").start();

    }
}
