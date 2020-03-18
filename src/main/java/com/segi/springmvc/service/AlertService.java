package com.segi.springmvc.service;

import com.segi.springmvc.model.Spittle;

/**
 * @author chenzx
 * @date 2018-10-16 上午 10:08
 */
public interface AlertService {
    public void sendSpittleAlert(Spittle spittle);

    public Spittle receiveSpittleAlert();
}
