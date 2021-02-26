package com.noodles.design_pattern.chain_responsibility.pipeline;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @ClassName PipelineContext
 * @Description 定义管道处理的上下文
 * 参考链接： https://my.oschina.net/u/4662964/blog/4759287
 * @Author noodles
 * @Date 2021/2/26 13:58
 */
@Getter
@Setter
public class PipelineContext {
    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
