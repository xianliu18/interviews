package com.noodles.netty.dubborpc.provider;

import com.noodles.netty.dubborpc.minterface.HelloService;

/**
 * @ClassName HelloServiceImpl
 * @Description 实现类
 * @Author noodles
 * @Date 2021/3/9 9:16
 */
public class HelloServiceImpl implements HelloService {
    // 当消费方调用该方法时， 返回一个结果
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息: " + msg);
        if (msg != null) {
            return "已收到如下消息 ---》 " + msg;
        } else {
            return "已收到消息";
        }
    }
}
