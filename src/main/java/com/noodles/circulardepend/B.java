package com.noodles.circulardepend;

/**
 * @ClassName B
 * @Description 类 B
 * @Author noodles
 * @Date 2021/1/12 16:07
 */
public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B() {
        System.out.println("----- B created success");
    }
}
