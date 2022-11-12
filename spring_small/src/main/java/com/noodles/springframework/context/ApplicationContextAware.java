package com.noodles.springframework.context;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.Aware;

/**
 * @description: 实现此接口，可以感知到所属的 ApplicationContext
 * @author: liuxian
 * @date: 2022-11-12 21:56
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
