package com.noodles.basic;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RowHashMap
 * @Description 原始hashmap
 * @Author noodles
 * @Date 2021/1/14 18:09
 */
public class RowHashMap {
    public static void main(String[] args) {
        // 初始化一组字符串
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("noodles");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        // 定义要存放的数组
        String[] res = new String[8];

        // 循环存放
        for (String key : list) {
            int idx = key.hashCode() & (res.length - 1);
            System.out.println(String.format("key的值为: %s, idx的值为：%d", key, idx));
            if (res[idx] == null) {
                res[idx] = key;
                continue;
            }
            res[idx] = res[idx] + "->" + key;
        }

        System.out.println(JSON.toJSONString(res));
    }
}
