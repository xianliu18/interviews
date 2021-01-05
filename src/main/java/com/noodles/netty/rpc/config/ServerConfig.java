package com.noodles.netty.rpc.config;

/**
 * @Description: 注册中心配置
 * @Author: noodles
 * @create: 2021-01-05 08:01
 */
public class ServerConfig {

    protected String host;
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
