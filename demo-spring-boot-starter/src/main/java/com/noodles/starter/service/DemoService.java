package com.noodles.starter.service;

/**
 * @ClassName DemoService
 * @Description 服务层
 * @Author noodles
 * @Date 2021/2/2 16:15
 */
public class DemoService {

    public String sayWhat;
    public String toWho;

    public DemoService(String sayWhat, String toWho) {
        this.sayWhat = sayWhat;
        this.toWho = toWho;
    }

    public String say() {
        return this.sayWhat + "! " + toWho;
    }
}
