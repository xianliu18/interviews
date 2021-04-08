package com.noodles.collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapDemo
 * @Description Map 测试示例
 * @Author noodles
 * @Date 2021/4/8 16:37
 */
public class MapDemo {
    /**
     * key 和 value 都允许为null
     * key 为 null 时，hash 值默认为 0
     */
    @Test
    public void test_hashMap_nullkey() {
        Map<String, String> map = new HashMap<>();
        map.put(null, "abc");
    }
}
