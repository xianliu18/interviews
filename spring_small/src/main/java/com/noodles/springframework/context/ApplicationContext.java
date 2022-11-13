package com.noodles.springframework.context;

import com.noodles.springframework.beans.factory.HierarchicalBeanFactory;
import com.noodles.springframework.beans.factory.ListableBeanFactory;
import com.noodles.springframework.core.io.ResourceLoader;

/**
 * @description: 应用上下文
 * @author: liuxian
 * @date: 2022-11-12 15:39
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
