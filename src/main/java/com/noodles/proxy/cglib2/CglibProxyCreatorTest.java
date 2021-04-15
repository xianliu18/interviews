package com.noodles.proxy.cglib2;

import com.noodles.proxy.jdk.ProxyCreator;
import org.junit.Test;

/**
 * @ClassName CglibProxyCreatorTest
 * @Description 测试用例
 *      参考链接： http://www.tianxiaobo.com/2018/06/20/Spring-AOP-源码分析-创建代理对象/
 * @Author noodles
 * @Date 2021/2/23 13:46
 */
public class CglibProxyCreatorTest {

    @Test
    public void getProxy() {
        ProxyCreator proxyCreator = new CglibProxyCreator(new Tank59(), new TankRemanufature());
        Tank59 tank59 = (Tank59)proxyCreator.getProxy();

        System.out.println("proxy class = " + tank59.getClass() + "\n");
        tank59.run();
        System.out.println();
        System.out.println("射击测试：");
        tank59.shoot();
    }
}
