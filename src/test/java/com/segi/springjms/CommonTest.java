package com.segi.springjms;

import com.segi.springmvc.MyWebAppInitializer2;
import com.segi.springmvc.RootConfig;
import com.segi.springmvc.handler.SpittleAlertHandler;
import com.segi.springmvc.model.Spittle;
import com.segi.springmvc.service.AlertService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;
import java.util.Date;

/**
 * @author chenzx
 * @date 2018-10-16 上午 9:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class CommonTest {

    @Autowired
    AlertService alertService;

    @Autowired
    SpittleAlertHandler spittleAlertHandler;

    @Test
    public void originalSend() {
        Connection conn = null;
        Session session = null;
        try {
            ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
            cf.setBrokerURL("tcp://localhost:61616");
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            ActiveMQQueue queue = new ActiveMQQueue("mq.queue");
            MessageProducer producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setText("hello, world!");
            //发送消息
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != session) {
                    session.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void originalRecv() {
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

    @Test
    public void mdpSend() {
        System.out.println("发送...");
        alertService.sendSpittleAlert(new Spittle("chenzixuan", new Date()));
        System.out.println("发送完毕");
    }

    @Test
    public void mdprecv() {
        System.out.println("接收...");
        Spittle spittle = alertService.receiveSpittleAlert();
        System.out.println(spittle);
        System.out.println("接收完毕");
    }

    @Test
    public void handlerRecv() {
        System.out.println("接收...");
//        spittleAlertHandler.receiveSpittleAlert();
        System.out.println("接收完毕");
    }
}
