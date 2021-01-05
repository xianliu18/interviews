package com.noodles.netty.rpc.config;

/**
 * @Description: 生产者配置
 * @Author: noodles
 * @create: 2021-01-05 07:33
 */
public class ProviderConfig {

    private String nozzle;
    private String ref;
    private String alias;

    // 发布
    protected void doExport() {
        System.out.format("生产者信息=>[接口: %s][映射: %s][别名: %s]\n", nozzle, ref, alias);
    }

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
