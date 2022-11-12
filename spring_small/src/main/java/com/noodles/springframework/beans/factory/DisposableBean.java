package com.noodles.springframework.beans.factory;

/**
 * @description: 自定义销毁 bean 接口
 * @author: liuxian
 * @date: 2022-11-12 18:14
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
