package com.noodles.design_pattern.chain_responsibility.pipeline.handler;

import com.noodles.design_pattern.chain_responsibility.pipeline.ContextHandler;
import com.noodles.design_pattern.chain_responsibility.pipeline.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName ModelInstanceSaver
 * @Description 处理器 - 保存模型实例到相关DB表
 * @Author noodles
 * @Date 2021/2/26 14:37
 */
@Component
public class ModelInstanceSaver implements ContextHandler<InstanceBuildContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {

        logger.info("-- 保存模型实例到相关DB表 --");

        // 保存模型实例

        return true;
    }
}
