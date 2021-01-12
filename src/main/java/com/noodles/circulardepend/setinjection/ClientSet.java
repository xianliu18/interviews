package com.noodles.circulardepend.setinjection;

/**
 * @ClassName ClientSet
 * @Description 测试类
 * @Author noodles
 * @Date 2021/1/12 16:01
 */
public class ClientSet {
    public static void main(String[] args) {
        ServiceAA a = new ServiceAA();
        ServiceBB b = new ServiceBB();

        b.setServiceAA(a);
        a.setServiceBB(b);
    }
}
