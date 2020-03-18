package com.segi.spring.IOC.model;

import com.segi.spring.IOC.annotation.Cold;
import com.segi.spring.IOC.annotation.Ice;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author chenzx
 * @date 2018-10-08 上午 9:17
 */
@Component
@Cold
@Ice
//@Primary//标注为首选的，当有多个实现类时，首选它。只能唯一标注
@Data
public class IceCream implements Dessert {
    public int count;
}
