package com.noodles.jvm.java8;

/**
 * @Description:
 * @Author:
 * @create: 2021-01-25 22:20
 */
public class BeanB {

    private String name;
    private Integer age;

    public BeanB(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(name);
        sb.append("|").append(age);
        return sb.toString();
    }
}
