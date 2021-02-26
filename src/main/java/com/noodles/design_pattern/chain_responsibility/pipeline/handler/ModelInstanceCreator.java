package com.noodles.design_pattern.chain_responsibility.pipeline.handler;

import com.noodles.design_pattern.chain_responsibility.pipeline.ContextHandler;
import com.noodles.design_pattern.chain_responsibility.pipeline.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName ModelInstanceCreator
 * @Description 处理器 - 根据输入创建模型实例
 * @Author noodles
 * @Date 2021/2/26 14:35
 */
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("-- 根据输入数据创建模型实例 --");

        // 创建模型实例

        return true;
    }
}
