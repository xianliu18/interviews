package com.noodles.circulardepend;

/**
 * @ClassName ClientCode
 * @Description 客户端代码
 * @Author noodles
 * @Date 2021/1/12 16:07
 */
public class ClientCode {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        b.setA(a);
        a.setB(b);
    }
}
