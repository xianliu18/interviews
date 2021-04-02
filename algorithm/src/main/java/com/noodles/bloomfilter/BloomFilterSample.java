package com.noodles.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName BloomFilterSample
 * @Description 布隆过滤器
 *
 * 参考链接： https://www.cnblogs.com/lonely-wolf/p/14451302.html
 *
 * @Author noodles
 * @Date 2021/4/2 11:37
 */
public class BloomFilterSample {

    private static final int expectedInsertions = 1000000;

    public static void main(String[] args) {
//        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
//        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 500, 0.01);
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), expectedInsertions);

        List<String> list = new ArrayList<>(expectedInsertions);

        for (int i = 0; i < expectedInsertions; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            list.add(uuid);
        }

        int mightContainNum1 = 0;

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);

        for (int i = 0; i < 500; i++) {
            String key = list.get(i);
            if (bloomFilter.mightContain(key)) {
                mightContainNum1++;
            }
        }
        System.out.println("[Key真实存在]布隆过滤器认为存在的key值数：" + mightContainNum1);
        System.out.println("-----------------------分割线---------------------------------");

        int mightContainNum2 = 0;

        for (int i = 0; i < expectedInsertions; i++) {
            String key = UUID.randomUUID().toString();
            if (bloomFilter.mightContain(key)) {
                mightContainNum2++;
            }
        }

        System.out.println("[key不存在的情况]布隆过滤器认为存在的key值数：" + mightContainNum2);
        System.out.println("误判率：" + percentFormat.format((float)mightContainNum2 / expectedInsertions));
    }
}
