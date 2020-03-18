package com.segi.shang.interview.JVM;
import	java.lang.ref.ReferenceQueue;
import	java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author chenzx
 * @date 2020-03-09 下午 10:15
 */
public class RefQueueTest {

    public static void main(String[] args) {
        Object obj1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> reference = new WeakReference<Object> (obj1, referenceQueue);

        System.out.println(obj1);
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("====================");
        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll());

    }
}
