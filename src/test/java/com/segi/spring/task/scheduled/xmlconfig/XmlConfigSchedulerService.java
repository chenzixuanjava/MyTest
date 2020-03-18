package com.segi.spring.task.scheduled.xmlconfig;

import org.springframework.stereotype.Service;

/**
 * @author chenzx
 * @date 2019-04-28 上午 11:58
 */
@Service
public class XmlConfigSchedulerService {

    public void doScheduledTask() {
        System.out.println(Thread.currentThread().getName() + "：执行");
    }
}
