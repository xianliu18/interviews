package com.noodles.design_pattern.chain_responsibility.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PipelineExecutor
 * @Description 管道执行器
 * @Author noodles
 * @Date 2021/2/26 14:57
 */
@Component
public class PipelineExecutor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private Map<Class<? extends PipelineContext>,
                List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap;

    /**
     * @Author noodles
     * @Description
     *     同步处理输入的上下文数据<br/>
     *     如果处理时，上下文数据流通到最后一个处理器且最后一个处理器返回 true， 则返回 true， 否则返回 false
     * @Date 2021/2/26 14:59
     * @Param [context]
     * @return boolean
     */
    public boolean acceptSync(PipelineContext context) {
        Assert.notNull(context, "上下文数据不能为 null");

        // 拿到数据类型
        Class<? extends PipelineContext> dataType = context.getClass();

        // 获取数据处理管道
        List<? extends ContextHandler<? super PipelineContext>> pipeline = pipelineRouteMap.get(dataType);

        if (CollectionUtils.isEmpty(pipeline)) {
            logger.error("{} 的管道为空", dataType.getSimpleName());
            return false;
        }

        // 管道是否畅通
        boolean lastSucess = true;

        for (ContextHandler<? super PipelineContext> handler : pipeline) {
            try {
                // 当前处理器处理数据， 并返回是否继续向下处理
                lastSucess = handler.handle(context);
            } catch (Throwable ex) {
                lastSucess = false;
                logger.error("[{}] 处理异常, handler = {}", context.getName(), handler.getClass().getSimpleName(), ex);
            }

            // 不再向下处理
            if (!lastSucess) {
                break;
            }
        }
        return lastSucess;
    }
}
