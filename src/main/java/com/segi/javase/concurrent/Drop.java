package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-06 下午 2:00
 */
public class Drop {

    /**
     * 生产者发送给消费者的消息
     */
    private String message;
    /**
     * true:消费者等待生产者生产消息
     * false:生产者等待消费者消费消息
     */
    private boolean empty;

    public synchronized String take() {
        //等待，直到消息被提供
        if (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //置换状态
        empty = true;
        //通知生产者状态已经被改变
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        //等待，直到消息被消费
        if (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //置换状态
        empty = false;
        this.message = message;
        //通知消费者状态已经被改变
        notifyAll();
    }
}
