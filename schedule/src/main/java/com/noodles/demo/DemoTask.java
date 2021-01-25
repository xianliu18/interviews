package com.noodles.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 测试样例
 * @Author: noodles
 * @create: 2021-01-24 12:42
 */
@Slf4j
public class DemoTask {

    public void execute() throws Exception {
        log.info("定时处理用户信息任务: 0/5 * * * * ?");
    }

}
