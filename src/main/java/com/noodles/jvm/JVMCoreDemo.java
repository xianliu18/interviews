package com.noodles.jvm;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @Description: 查看对象头信息
 *      参考连接: https://bugstack.cn/interview/2020/10/28/面经手册-第15篇-码农会锁-synchronized-解毒-剖析源码深度分析.html
 *
 *      VM 参数, 关闭指针压缩: -XX:-UseCompressedOops
 * @Author: noodles
 * @create: 2021-04-10 12:00
 */
public class JVMCoreDemo {
    @Test
    public void test_JvmCore() {
        System.out.println(VM.current().details());
        Object obj = new Object();
        System.out.println(obj + "十六进制哈希: " + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
