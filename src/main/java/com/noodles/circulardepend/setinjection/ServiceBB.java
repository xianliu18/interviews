package com.noodles.circulardepend.setinjection;

import org.springframework.stereotype.Component;

/**
 * @ClassName ServiceBB
 * @Description BB 服务
 * @Author noodles
 * @Date 2021/1/12 16:00
 */
@Component
public class ServiceBB {
    private ServiceAA serviceAA;

    public void setServiceAA(ServiceAA serviceAA) {
        this.serviceAA = serviceAA;
        System.out.println("B 里面设置了 A");
    }
}
