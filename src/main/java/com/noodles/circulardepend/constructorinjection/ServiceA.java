package com.noodles.circulardepend.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @ClassName serviceA
 * @Description A 服务
 * @Author noodles
 * @Date 2021/1/12 15:55
 */
@Component
public class ServiceA {
    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
