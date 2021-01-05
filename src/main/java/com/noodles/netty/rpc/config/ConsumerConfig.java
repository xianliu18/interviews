package com.noodles.netty.rpc.config;

/**
 * @Description: 消费者配置
 * @Author: noodles
 * @create: 2021-01-05 07:32
 */
public class ConsumerConfig<T> {

    private String nozzle;
    private String alias;

    // 动态代理链接
    protected synchronized T refer() {
        System.out.format("消费者信息=>[接口: %s] [别名: %s] \n", nozzle, alias);
        return null;
    }

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
