package com.noodles.netty.rpc.newrpc.config.spring.bean;

import com.noodles.netty.rpc.newrpc.config.ServerConfig;
import com.noodles.netty.rpc.newrpc.domain.LocalServerInfo;
import com.noodles.netty.rpc.newrpc.network.server.ServerSocket;
import com.noodles.netty.rpc.newrpc.registry.RedisRegistryCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName ServerBean
 * @Description 服务端实体
 * @Author noodles
 * @Date 2021/1/5 15:14
 */
@Slf4j
public class ServerBean extends ServerConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 启动注册中心
        log.info("启动注册中心...");
        RedisRegistryCenter.init(host, port);
        log.info("注册中心启动完成：{} {}", host, port);

        // 初始化服务端
        log.info("初始化生产端服务...");
        ServerSocket serverSocket = new ServerSocket(applicationContext);
        Thread thread = new Thread(serverSocket);
        thread.start();
        while (!serverSocket.isActiveSocketServer()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }

        log.info("生产端服务初始化完成 {} {}", LocalServerInfo.LOCAL_HOST, LocalServerInfo.LOCAL_PORT);
    }
}
