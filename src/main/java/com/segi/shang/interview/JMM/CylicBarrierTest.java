package com.segi.shang.interview.JMM;
import java.util.concurrent.BrokenBarrierException;
import	java.util.concurrent.CyclicBarrier;

/**
 * @author chenzx
 * @date 2020-03-05 上午 7:59
 */
public class CylicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(Thread.currentThread().getName() + "\t开会");
        });

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t进会议室");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
