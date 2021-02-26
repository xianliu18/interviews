package com.noodles.design_pattern.strategy2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FormSubmitHandlerFactory
 * @Description 建立策略的简单工厂
 * @Author noodles
 * @Date 2021/2/26 13:39
 */
public class FormSubmitHandlerFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<String, FormSubmitHandler> FORM_SUBMIT_HANDLER_MAP = new HashMap<>(8);

    private ApplicationContext applicationContext;
    
    /**
     * @Author noodles
     * @Description 根据提交类型获取对应的处理器
     */
    public FormSubmitHandler<Serializable> getHandler(String submitType) {
        return FORM_SUBMIT_HANDLER_MAP.get(submitType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 将 Spring 容器中所有的 FormSubmitHandler 注册到 FORM_SUBMIT_HANDLER_MAP
        applicationContext.getBeansOfType(FormSubmitHandler.class)
                          .values()
                          .forEach(handler -> FORM_SUBMIT_HANDLER_MAP.put(handler.getSubmitType(), handler));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
