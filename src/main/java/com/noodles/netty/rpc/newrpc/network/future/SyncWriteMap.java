package com.noodles.netty.rpc.newrpc.network.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SyncWriteMap
 * @Description 缓存类
 * @Author noodles
 * @Date 2021/1/5 15:36
 */
public class SyncWriteMap {

    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<>();

}
