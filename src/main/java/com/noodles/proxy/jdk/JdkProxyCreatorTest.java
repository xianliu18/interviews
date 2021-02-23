package com.noodles.proxy.jdk;

import org.junit.Test;

/**
 * @ClassName JdkProxyCreatorTest
 * @Description 测试类
 * @Author noodles
 * 参考链接： www.tianxiaobo.com/2018/06/20/Spring-AOP-源码分析-创建代理对象/
 * @Date 2021/2/23 13:26
 */
public class JdkProxyCreatorTest {

    @Test
    public void getProxy() {
        ProxyCreator proxyCreator = new JdkProxyCreator(new UserServiceImpl());
        UserService userService = (UserService) proxyCreator.getProxy();

        System.out.println("proxy type = " + userService.getClass());
        System.out.println();
        userService.save(null);
        System.out.println();
        userService.update(null);
    }
}
