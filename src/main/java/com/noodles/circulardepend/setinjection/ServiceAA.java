package com.noodles.circulardepend.setinjection;

import org.springframework.stereotype.Component;

/**
 * @ClassName ServiceAA
 * @Description AA 服务
 * @Author noodles
 * @Date 2021/1/12 16:00
 */
@Component
public class ServiceAA {
    private ServiceBB serviceBB;

    public void setServiceBB(ServiceBB serviceBB) {
        this.serviceBB = serviceBB;
        System.out.println("A 里面设置了 B");
    }
}
