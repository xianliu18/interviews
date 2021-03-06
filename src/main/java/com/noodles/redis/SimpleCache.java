package com.noodles.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 基于 LinkedHashMap 实现缓存
 * 参考连接: www.tianxiaobo.com/2018/01/24/LinkedHashMap-源码详细分析（JDK1-8）/#附录映射类文章列表
 * @Author: noodles
 * @create: 2021-03-06 13:49
 */
public class SimpleCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_NODE_NUM = 100;

    private int limit;

    public SimpleCache() {
        this(MAX_NODE_NUM);
    }

    public SimpleCache(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V save(K key, V val) {
        return put(key, val);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    /**
     * 判断节点数是否超限
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}
