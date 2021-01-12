package com.noodles.circulardepend.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @ClassName ServiceB
 * @Description 服务B
 * @Author noodles
 * @Date 2021/1/12 15:56
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
