package com.noodles.netty.rpc.newrpc.config.spring.bean;

import com.alibaba.fastjson.JSON;
import com.noodles.netty.rpc.newrpc.config.ProviderConfig;
import com.noodles.netty.rpc.newrpc.domain.LocalServerInfo;
import com.noodles.netty.rpc.newrpc.domain.RpcProviderConfig;
import com.noodles.netty.rpc.newrpc.registry.RedisRegistryCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName ProviderBean
 * @Description 生产者实体
 * @Author noodles
 * @Date 2021/1/5 15:14
 */
@Slf4j
public class ProviderBean extends ProviderConfig implements ApplicationContextAware {


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RpcProviderConfig rpcProviderConfig = new RpcProviderConfig();
        rpcProviderConfig.setNozzle(nozzle);
        rpcProviderConfig.setRef(ref);
        rpcProviderConfig.setAlias(alias);
        rpcProviderConfig.setHost(LocalServerInfo.LOCAL_HOST);
        rpcProviderConfig.setPort(LocalServerInfo.LOCAL_PORT);

        // 注册生产者
        long count = RedisRegistryCenter.registryProvider(nozzle, alias, JSON.toJSONString(rpcProviderConfig));

        log.info("注册生产者：{} {} {}", nozzle, alias, count);
    }
}
