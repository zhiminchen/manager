package com.zhuoqu.slg.data.bi.stats.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * @author : pardon
 * Date: 2018/12/25
 * Time: 18:18
 */
@Component
public class BeansUtil implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeansUtil.class);

    private ApplicationContext context;
    private static BeansUtil factory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        factory = this;
    }

    public void printBeans() {
        String[] beanNames = context.getBeanDefinitionNames();

        LOGGER.info("bean总数:{}", context.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
            LOGGER.info("{},beanName:{}", ++i, str);
        }
    }

    public Object getBean(String name) {
        return context.getBean(name);
    }

    public <T> T getBean(String name ,Class<T> tClass){
        return (T)context.getBean(name);
    }




    public <T>T getBean(Class<T> className) {
        return context.getBean(className);
    }

    public static BeansUtil buildFactory(){
        return factory;
    }
}
