package com.noodles.netty.rpc.newrpc.config;

/**
 * @ClassName ServerConfig
 * @Description 注册中心配置
 * @Author noodles
 * @Date 2021/1/5 15:00
 */
public class ServerConfig {
    // 注册中心地址
    protected String host;
    // 注册中心端口
    protected int port;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
