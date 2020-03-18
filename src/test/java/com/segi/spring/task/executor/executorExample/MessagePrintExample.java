package com.segi.spring.task.executor.executorExample;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-22 上午 10:03
 */
@Data
@Component
public class MessagePrintExample {

    @Data
    private class MessagePrintTask implements Runnable {
        private String message;

        public MessagePrintTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + ": " + message);
        }
    }

    @Autowired
    private TaskExecutor taskExecutor;

    public MessagePrintExample() {
    }

    public void printMessage() {
        for (int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrintTask("Message" + i));
        }
    }
}
