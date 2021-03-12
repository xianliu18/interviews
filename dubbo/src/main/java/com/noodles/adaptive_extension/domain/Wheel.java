package com.noodles.adaptive_extension.domain;

/**
 * @ClassName Wheel
 * @Description Wheel 实体类
 * @Author noodles
 * @Date 2021/3/12 10:42
 */
public class Wheel {

    public Wheel() {
    }

    public Wheel(String maker) {
        this.maker = maker;
    }

    private String maker;

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
