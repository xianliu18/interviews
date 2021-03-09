package com.noodles.netty.dubborpc.minterface;

/**
 * @Author noodles
 * @Description 公共接口，服务提供方和消费方都需要
 * @Date 2021/3/9 9:17
 * @Param 
 * @return 
 */
public interface HelloService {

    String hello(String msg);

}
