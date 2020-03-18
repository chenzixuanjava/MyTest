package com.segi.shang.interview.JVM;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import sun.misc.VM;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzx
 * @date 2020-03-10 上午 8:40
 */
public class OOMTest {

    public static void main(String[] args) {
//        stackOverflowError();
//        heap();
        gcOverhead();
//        directBufferMemory();
//          CanNotCreateMoreThread();
//        metaSpace(args);
    }

    /**
     * java.lang.OutOfMemoryError: Metaspace
     * @param args
     */
    private static void metaSpace(String[] args) {
        int i = 0;
        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setUseCache(false);
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable t) {
            System.out.println("第" + i + "次");
            t.printStackTrace();
        }
    }

    /**
     * unable to create new native thread
     */
    private static void CanNotCreateMoreThread() {
        for (int i = 0;; i++) {
            System.out.println(i);
            new Thread(() -> {
                try {Thread.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) {e.printStackTrace();}
            }, String.valueOf(i)).start();
        }
    }

    /**
     * Direct buffer memory
     */
    private static void directBufferMemory() {
        System.out.println(VM.maxDirectMemory() / 1024 / 1024);

        ByteBuffer.allocateDirect(10 * 1024 * 1024);
    }

    /**
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    private static void gcOverhead() {
        try {
            int temp = 0;
            List<String> list = new ArrayList<>();
            while (true) {
                list.add(String.valueOf(++temp).intern());
            }
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
        }
    }

    /**
     * java.lang.OutOfMemoryError: Java heap space
     */
    private static void heap() {
        byte[] b = new byte[50 * 1024 * 1024];
    }

    /**
     * java.lang.StackOverflowError
     */
    private static void stackOverflowError() {
        stackOverflowError();
    }
}
