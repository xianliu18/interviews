package com.noodles.design_pattern.chain_responsibility.pipeline.handler;

import com.noodles.design_pattern.chain_responsibility.pipeline.ContextHandler;
import com.noodles.design_pattern.chain_responsibility.pipeline.InstanceBuildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @ClassName InputDataPreChecker
 * @Description 处理器 - 输入数据校验
 * @Author noodles
 * @Date 2021/2/26 14:31
 */
@Component
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("-- 输入数据校验 --");

        Map<String, Object> formInput = context.getFormInput();

        if (CollectionUtils.isEmpty(formInput)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }

        String instanceName = (String)formInput.get("instanceName");

        if (StringUtils.isEmpty(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }

        return true;
    }
}
