package com.noodles.netty.dubborpc.customer;

import com.noodles.netty.dubborpc.minterface.HelloService;
import com.noodles.netty.dubborpc.netty.NettyClient;

/**
 * @ClassName ClientBootstrap
 * @Description 服务消费方启动类
 * @Author noodles
 * @Date 2021/3/9 10:10
 */
public class ClientBootstrap {

    // 定义协议头
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        // 创建一个消费者
        NettyClient customer = new NettyClient();

        // 创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        // 通过代理对象调用服务提供方的方法
        String res = service.hello("dubbo rpc调用~~");
        System.out.println("调用的结果为: " + res);
    }
}
