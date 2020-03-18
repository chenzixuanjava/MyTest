package com.segi.activiti5.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * @author chenzx
 * @date 2018-11-21 下午 4:58
 */
public class MyActivitiListener implements ActivitiEventListener {

    @Override
    public void onEvent(ActivitiEvent activitiEvent) {
        System.out.println("MyActivitiListener监听到了");
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
