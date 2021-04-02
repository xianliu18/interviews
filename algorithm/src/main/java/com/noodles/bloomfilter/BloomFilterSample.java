package com.noodles.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @ClassName BloomFilterSample
 * @Description 布隆过滤器
 * @Author noodles
 * @Date 2021/4/2 11:37
 */
public class BloomFilterSample {
    public static void main(String[] args) {
//        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 500, 0.01);

        filter.put("Hello World!");

        System.out.println(filter.mightContain("hello world"));
        System.out.println(filter.mightContain("Hello World!"));
    }
}
