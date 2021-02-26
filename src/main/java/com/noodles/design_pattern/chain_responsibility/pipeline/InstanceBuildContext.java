package com.noodles.design_pattern.chain_responsibility.pipeline;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @ClassName InstanceBuildContext
 * @Description 模型实例构建的上下文
 * @Author noodles
 * @Date 2021/2/26 14:24
 */
@Getter
@Setter
public class InstanceBuildContext extends PipelineContext {
    
    /**
     * 模型 id
     */
    private Long modelId;

    /**
     * 用户 id
     */
    private long userId;

    /**
     * 表单输入
     */
    private Map<String, Object> formInput;

    /**
     * 保存模型实例完成后，记录下 id
     */
    private Long instanceId;

    /**
     * 模型创建出错时的错误信息
     */
    private String errorMsg;

    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
    
}
