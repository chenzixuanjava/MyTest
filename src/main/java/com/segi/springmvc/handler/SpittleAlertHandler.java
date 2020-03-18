package com.segi.springmvc.handler;

import com.segi.springmvc.model.Spittle;

import javax.jms.*;

/**
 * @author chenzx
 * @date 2018-10-16 上午 11:23
 */
public class SpittleAlertHandler{

    public void receiveSpittleAlert(Spittle spittle) {
        System.out.println("hanler-receive");
        System.out.println(spittle);
    }
}
