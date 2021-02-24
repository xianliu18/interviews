package com.noodles.design_pattern.strategy;

import org.junit.Test;

/**
 * @ClassName StrategyTest
 * @Description 测试类
 * @Author noodles
 * @Date 2021/2/24 13:34
 */
public class StrategyTest {

    @Test
    public void test() {
        PersonContext person = new PersonContext();

        person.travel(1500);

        person.travel(100);

        person.travel(1);
    }
}
