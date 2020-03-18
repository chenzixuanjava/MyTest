package com.segi.springmvc.controller;

import com.segi.springmvc.model.Spittle;
import com.segi.springmvc.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzx
 * @date 2018-10-16 上午 9:28
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    @Autowired
    @Qualifier("rabbitAlertServiceImpl")
    AlertService rabbitAlertService;


    @PostMapping("/sendSpittle")
    public void send(@RequestBody Spittle spittle) {
        System.out.println(spittle);
        rabbitAlertService.sendSpittleAlert(spittle);

    }

    @PostMapping("receiveSpittle")
    public Spittle receive() {
        System.out.println("receive()");
        Spittle spittle = rabbitAlertService.receiveSpittleAlert();
        System.out.println(spittle);
        System.out.println("接收完毕");
        return spittle;
    }

}
