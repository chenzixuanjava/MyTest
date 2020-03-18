package com.segi.springmvc.service.impl;

import com.segi.springmvc.model.Spittle;
import com.segi.springmvc.service.AlertService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenzx
 * @date 2018-10-16 上午 10:17
 */
@Service("rabbitAlertServiceImpl")
public class RabbitAlertServiceImpl implements AlertService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        System.out.println("send...");
        //exchange和routing-key的默认名字都为空
        rabbitTemplate.convertAndSend(spittle);

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
        /*
        * 调用receive()和receiveAndConvert()方法都会立即返回，如果队列中没有等待的消息时，将会得到null。
        * 这就需要我们来管理轮询（polling）以及必要的线程，实现队列的监控。我们并非必须同步轮询并等待消息到达，
        * Spring AMQP还提供了消息驱动POJO的支持
        * */
        return (Spittle) rabbitTemplate.receiveAndConvert();
    }


}
