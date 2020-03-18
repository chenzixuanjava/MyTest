package com.segi.spring.IOC.model;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author chenzx
 * @date 2018-10-08 上午 8:48
 */
public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        /*
        Environment env = conditionContext.getEnvironment();
        return env.containsProperty("magic");*/

        /*ClassLoader classLoader = conditionContext.getClassLoader();
        Class<?> clazz = null;
        try {
            clazz = classLoader.loadClass("com.segi.spring.IOC.model.Man");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null != clazz;*/

        return annotatedTypeMetadata.isAnnotated("org.springframework.context.annotation.Bean");
    }
}
