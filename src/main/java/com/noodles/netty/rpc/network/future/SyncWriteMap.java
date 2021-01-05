package com.noodles.netty.rpc.network.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SyncWriteMap
 * @Description 自定义集合类
 * @Author noodles
 * @Date 2021/1/5 10:35
 */
public class SyncWriteMap {

    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<>();

}
