package com.noodles.netty.test.asm;

import com.noodles.design_pattern.singleton.Singleton04;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: noodles
 * @create: 2021-01-06 22:25
 */
public class ApiTest {

    public static void main(String[] args) {
        ApiTest apiTest = new ApiTest();
        String res = apiTest.queryUserInfo(111, 25);
        System.out.println("测试结果:" + res + "\n");
    }

    @Test
    public void testSingleton() {
        // 单例测试
        System.out.println(Singleton04.getInstance().getClass());
    }

    public String queryUserInfo(int uid, int age) {
        return "今天风好大,气温好低!!";
    }
}
