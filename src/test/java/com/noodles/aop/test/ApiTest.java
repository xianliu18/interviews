package com.noodles.aop.test;

import com.noodles.utils.FileUtil;
import com.noodles.utils.HashCode;
import com.noodles.utils.RateInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @ClassName ApiTest
 * @Description TODO
 * @Author noodles
 * @Date 2021/1/14 16:58
 */
public class ApiTest {

    private Set<String> words;

    @Before
    public void before() {
        // 读取文件
        System.out.println(System.getProperty("user.dir"));
        words = FileUtil.readWordList("./src/main/resources/103976个英语单词库.txt");
    }

    @Test
    public void test_collisionRate() {
        System.out.println("单词数量：" + words.size());
        List<RateInfo> rateInfoList = HashCode.collisionRateList(words, 2, 3, 5, 7, 17, 31, 32, 33, 39, 41, 199);
        for (RateInfo rate : rateInfoList) {
            System.out.println(String.format("乘数 = %d, 最小Hash = %11d， 最大Hash = %10d， 碰撞数量 = %6d， 碰撞概率 = %.4f%%", rate.getMultiplier(), rate.getMinHash(), rate.getMaxHash(), rate.getCollisionCount(), rate.getCollisionRate()));
        }
    }

    @Test
    public void test_hasArea() {
        System.out.println(HashCode.hashArea(words, 2).values());
        System.out.println(HashCode.hashArea(words, 7).values());
        System.out.println(HashCode.hashArea(words, 31).values());
        System.out.println(HashCode.hashArea(words, 32).values());
        System.out.println(HashCode.hashArea(words, 199).values());
    }
}
