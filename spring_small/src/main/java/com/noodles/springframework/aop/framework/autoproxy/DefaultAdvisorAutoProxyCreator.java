package com.noodles.springframework.aop.framework.autoproxy;

import com.noodles.springframework.aop.AdvisedSupport;
import com.noodles.springframework.aop.Advisor;
import com.noodles.springframework.aop.ClassFilter;
import com.noodles.springframework.aop.Pointcut;
import com.noodles.springframework.aop.TargetSource;
import com.noodles.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.noodles.springframework.aop.framework.ProxyFactory;
import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.PropertyValues;
import com.noodles.springframework.beans.factory.BeanFactory;
import com.noodles.springframework.beans.factory.BeanFactoryAware;
import com.noodles.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.noodles.springframework.beans.factory.support.DefaultListableBeanFactory;
import java.util.Collection;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @description: DefaultAdvisorAutoProxyCreator
 * @author: liuxian
 * @date: 2022-11-13 16:58
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        if (isInfrastructureClass(beanClass)) return null;

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();

            if (!classFilter.matches(beanClass)) continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            return new ProxyFactory(advisedSupport).getProxy();
        }

        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
