package com.noodles.netty.rpc.newrpc.config;

/**
 * @ClassName ProviderConfig
 * @Description 生产者配置
 * @Author noodles
 * @Date 2021/1/5 14:59
 */
public class ProviderConfig {

    // 接口
    protected String nozzle;
    // 映射
    protected String ref;
    // 别名
    protected String alias;

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
}
