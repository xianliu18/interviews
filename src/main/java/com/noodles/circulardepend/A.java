package com.noodles.circulardepend;

/**
 * @ClassName A
 * @Description TODO
 * @Author noodles
 * @Date 2021/1/12 16:07
 */
public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("----A created success");
    }
}
