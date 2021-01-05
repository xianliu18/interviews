package com.noodles.netty.rpc.newrpc.config;

/**
 * @ClassName ConsumerConfig
 * @Description 消费者配置
 * @Author noodles
 * @Date 2021/1/5 14:59
 */
public class ConsumerConfig<T> {

    // 接口
    protected String nozzle;
    // 别名
    protected String alias;

    public String getNozzle() {
        return nozzle;
    }

    public void setNozzle(String nozzle) {
        this.nozzle = nozzle;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
