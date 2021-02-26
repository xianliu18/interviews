package com.noodles.design_pattern.chain_responsibility.pipeline;

/**
 * @Author noodles
 * @Description 管道中的上下文处理器
 * @Date 2021/2/26 14:01
 */
public interface ContextHandler<T extends PipelineContext> {
    
    /**
     * @Author noodles
     * @Description 处理输入的上下文数据
     * @Date 2021/2/26 14:02
     * @Param [context]  处理时的上下文数据
     * @return boolean   返回 true，表示由下一个 ContextHandler 继续处理，返回 false，则表示处理结束
     */
    boolean handle(T context);
}
