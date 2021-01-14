package com.noodles.aop.test;

import com.alibaba.fastjson.JSON;
import com.noodles.basic.Disturb;
import com.noodles.utils.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Test_Disturb
 * @Description 扰动函数测试
 * @Author noodles
 * @Date 2021/1/14 19:13
 */
public class DisturbTest {

    private Set<String> words;

    @Before
    public void before() {
        // 读取文件
        System.out.println(System.getProperty("user.dir"));
        words = FileUtil.readWordList("./src/main/resources/103976个英语单词库.txt");
    }

    @Test
    public void test_disturb() {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : words) {
            // 使用扰动函数
            int idx = Disturb.disturbHashIdx(word, 128);
            // 不使用扰动函数
//            int idx = Disturb.hashIdx(word, 128);
            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            } else {
                map.put(idx, 1);
            }
        }
        System.out.println(map.values());
    }

    @Test
    public void test_threshold() {
        System.out.println(tableSizeFor(16));
    }


    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    @Test
    public void test_HashMap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");

        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key + "\tIdx(16): " + ((16-1)&hash) + "\tbit值： " + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16) + "\t\tIdx(32):" + ((32-1)&hash));
            System.out.println(Integer.toBinaryString(key.hashCode()) + " " + Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }
    }


    @Test
    public void test_128hash() {
        // 初始化一组字符串
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("noodles");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        String[] res = new String[8];

        // 循环存放
        for (String key : list) {
            int idx = Disturb.disturbHashIdx(key, 8);
            System.out.println(String.format("key的值为= %s, Idx的值为：%d", key, idx));
            if (null == res[idx]) {
                res[idx] = key;
                continue;
            }
            res[idx] = res[idx] + "->" + key;
        }

        System.out.println("测试结果：" + JSON.toJSONString(res));
    }

}
