package com.segi.javase.concurrent;

/**
 * @author chenzx
 * @date 2019-06-11 下午 4:41
 */
public class BadThread {
    //    static String message;
    static MsgObject msgObject = new MsgObject();
    static class CorrectorThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Key statement 1:
//            message = "CorrectorThread线程的消息";
            setMessage("CorrectorThread线程的消息");
        }

        public synchronized static void setMessage(String message) {
            BadThread.msgObject.setMessage(message);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CorrectorThread correctorThread = new CorrectorThread();
        correctorThread.start();
//        message = "主线程的消息";
//        CorrectorThread.setMessage("主线程的消息");
//        BadThread.msgObject.setMessage("主线程的消息");
        CorrectorThread.setMessage("主线程的消息");
        Thread.sleep(2000);
//        correctorThread.join();
        // Key statement 2
        System.out.println(BadThread.msgObject.getMessage());
    }
}

class MsgObject {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
