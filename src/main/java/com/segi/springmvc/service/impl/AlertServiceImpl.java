package com.segi.springmvc.service.impl;

import com.segi.springmvc.model.Spittle;
import com.segi.springmvc.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @author chenzx
 * @date 2018-10-16 上午 10:17
 */
@Service("alertServiceImpl")
public class AlertServiceImpl implements AlertService {

    @Autowired
    JmsOperations jmsOperations;

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        /*jmsOperations.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spittle);
            }
        });*/
        System.out.println("send...");
        jmsOperations.convertAndSend(spittle);

    }

    @Override
    public Spittle receiveSpittleAlert() {
        /*try {
            ObjectMessage message = (ObjectMessage) jmsOperations.receive();
            return (Spittle) message.getObject();
        } catch (JMSException e) {
            *//*
             * JmsTemplate可以很好地处理抛出的JmsException检查型异常，然后把异常转换为Spring非检查型异常
             * JmsException并重新抛出。但是它只对调用JmsTemplate的方法时才适用。JmsTemplate无法处理调用
             * ObjectMessage的getObject()方法时所抛出的JMSException异常
             *//*
            JmsUtils.convertJmsAccessException(e);
        }
        return null;*/
        //使用JmsTemplate接收消息的最大缺点在于receive()和receiveAndConvert()方法都是同步的
        System.out.println("receive...");
        return (Spittle) jmsOperations.receiveAndConvert();
    }


}
