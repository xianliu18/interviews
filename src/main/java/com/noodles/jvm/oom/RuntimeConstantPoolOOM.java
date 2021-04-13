package com.noodles.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RuntimeConstantPoolOOM
 * @Description 字符串常量池
 *      参考链接：https://zhuanlan.zhihu.com/p/257419418
 *      VM options: -Xmx 6m
 * @Author noodles
 * @Date 2021/4/13 18:16
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用 Set 保持着常量池引用， 避免 Full GC回收常量池行为
        Set<String> set = new HashSet<>();

        int i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
