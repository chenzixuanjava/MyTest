package com.segi.activiti5.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * @author chenzx
 * @date 2018-11-21 下午 4:58
 */
public class MyActivitiListenerTyped implements ActivitiEventListener {

    @Override
    public void onEvent(ActivitiEvent activitiEvent) {
        switch (activitiEvent.getType()) {
            case JOB_EXECUTION_SUCCESS:
                System.out.println("MyActivitiListenerTyped监听到了JOB_EXECUTION_SUCCESS");
                break;
            case JOB_EXECUTION_FAILURE:
                System.out.println("MyActivitiListenerTyped监听到了JOB_EXECUTION_FAILURE");
                break;
            default:
                System.out.println("MyActivitiListenerTyped监听到了");
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
