package com.segi.springjms;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author chenzx
 * @date 2018-10-16 上午 9:52
 */
public class ActiveMqOriRecv2 {
    public static void main(String[] args) {
        Connection conn = null;
        Session session = null;
        try {
            ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
            cf.setBrokerURL("tcp://localhost:61616");
            conn = cf.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            ActiveMQQueue queue = new ActiveMQQueue("mq.queue");
            MessageConsumer consumer = session.createConsumer(queue);
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println("msg:" + text);
            conn.start();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
                if (null != session) {
                    session.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
