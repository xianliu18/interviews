package com.noodles.springframework.context.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.noodles.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.noodles.springframework.beans.factory.config.BeanPostProcessor;
import com.noodles.springframework.context.ApplicationEvent;
import com.noodles.springframework.context.ApplicationListener;
import com.noodles.springframework.context.ConfigurableApplicationContext;
import com.noodles.springframework.context.event.ApplicationEventMulticaster;
import com.noodles.springframework.context.event.ContextClosedEvent;
import com.noodles.springframework.context.event.ContextRefreshedEvent;
import com.noodles.springframework.context.event.SimpleApplicationEventMulticaster;
import com.noodles.springframework.core.io.DefaultResourceLoader;
import java.util.Collection;
import java.util.Map;

/**
 * @description: 抽象应用上下文
 * @author: liuxian
 * @date: 2022-11-12 15:40
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 1, 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2, 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3, 添加 ApplicationContextAwareProcessor，让继承子 ApplicationContextAware 的
        //    Bean 对象都能感知到所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 3, 在 Bean 实例化之前，执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4, BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6, 初始化事件发布者
        initApplicationEventMulticaster();

        // 7, 注册事件监听器
        registerListeners();

        // 8, 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();

        // 9, 发布容器刷新完成事件
        finishRefresh();

    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessorMap.values()) {
            postProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> postProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor postProcessor : postProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(postProcessor);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));

        // 执行销毁单例 bean 的销毁方法
        getBeanFactory().destroySingletons();
    }
}
