package com.segi.spring.AOP.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author chenzx
 * @date 2018-10-08 下午 8:05
 */
@Aspect
public class EncorableAspect {
    @DeclareParents(value = "com.segi.spring.AOP.model.Performence+", defaultImpl = EncorableImpl.class)
    public static Encorable encorable;

}
