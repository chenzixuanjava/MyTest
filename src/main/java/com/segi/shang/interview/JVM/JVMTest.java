package com.segi.shang.interview.JVM;
import	java.lang.ref.WeakReference;
import	java.lang.ref.SoftReference;

/**
 * @author chenzx
 * @date 2020-03-08 上午 11:58
 */
public class JVMTest {

    public static void main(String[] args) {
//        vmEnough();
//        vmNotEnough();
        Object obj1 = new Object();
        WeakReference <Object> ref = new WeakReference<Object> (obj1);
        System.out.println(obj1);
        System.out.println(ref.get());

        obj1 = null;
        System.gc();
        System.out.println("===========================");

        System.out.println(obj1);
        System.out.println(ref.get());
    }

    public static void vmEnough() {
        Object obj1 = new Object();
        SoftReference<Object> soft = new SoftReference<> (obj1);
        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(soft.get());
    }

    public static void vmNotEnough() {
        Object obj1 = new Object();
        SoftReference<Object> soft = new SoftReference<> (obj1);
        obj1 = null;
        try {
            byte[] b = new byte[50 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(obj1);
            System.out.println(soft.get());
        }
    }
}
