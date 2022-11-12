package com.noodles.springframework.core.io;

/**
 * @description: 资源加载接口
 * @author: liuxian
 * @date: 2022-11-11 18:25
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
