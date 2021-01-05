package com.noodles.netty.rpc.newrpc.domain;

/**
 * @ClassName RpcProviderConfig
 * @Description Rpc生产者配置类
 * @Author noodles
 * @Date 2021/1/5 16:40
 */
public class RpcProviderConfig {

    private String nozzle; // 接口
    private String ref;    // 映射
    private String alias;  // 别名
    private String host;   // ip
    private int port;      // 端口

    public String getNozzle() {
        return nozzle;
    }

    public void setNozzle(String nozzle) {
        this.nozzle = nozzle;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

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
