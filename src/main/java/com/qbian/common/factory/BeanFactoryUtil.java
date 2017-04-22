package com.qbian.common.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * controller 根据请求接口查询 ApplicationContext 中对应的 Bean(service)
 * Created by qbian on 17/4/22.
 */
@Component
public final class BeanFactoryUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanFactoryUtil.context = applicationContext;
    }

    /**
     * 根据一个bean的id获取配置文件中相应的bean
     *
     * @param beanName className
     * @return Object
     * @throws BeansException BeansException
     */
    public static Object getBean(String beanName) throws BeansException {
        return context.getBean(beanName);
    }

}
