package com.noodles.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.noodles.provider.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloServiceImpl
 * @Description 服务提供方
 * @Author noodles
 * @Date 2021/3/12 15:45
 */
@Service
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("成功调用provider的方法~~~");
        return "hello$$" + name;
    }
}
