package com.noodles.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName DemoProperties
 * @Description 配置信息
 * @Author noodles
 * @Date 2021/2/2 16:10
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private String sayWhat;
    private String toWho;

    public String getSayWhat() {
        return sayWhat;
    }

    public void setSayWhat(String sayWhat) {
        this.sayWhat = sayWhat;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }
}
