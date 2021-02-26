package com.noodles.design_pattern.chain_responsibility.pipeline;

import com.noodles.design_pattern.chain_responsibility.pipeline.handler.InputDataPreChecker;
import com.noodles.design_pattern.chain_responsibility.pipeline.handler.ModelInstanceCreator;
import com.noodles.design_pattern.chain_responsibility.pipeline.handler.ModelInstanceSaver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName PipelineRouteConfig
 * @Description 管道路由的配置
 * @Author noodles
 * @Date 2021/2/26 14:44
 */
@Configuration
public class PipelineRouteConfig implements ApplicationContextAware {

    /**
     * 数据类型 -》 管道中处理器类型列表 的路由
     */
    private static final
        Map<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>> PIPELINE_ROUTE_MAP = new HashMap<>(4);

    /**
     * 配置各种上下文类型对应的处理管道： 键为上下文类型，值为处理器类型的列表
     */
    static {
        PIPELINE_ROUTE_MAP.put(InstanceBuildContext.class,
                Arrays.asList(
                        InputDataPreChecker.class,
                        ModelInstanceCreator.class,
                        ModelInstanceSaver.class
                ));
    }

    @Bean("pipelineRouteMap")
    public Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>> getHandlerPipelineMap() {
        return PIPELINE_ROUTE_MAP.entrySet()
                                 .stream()
                                 .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeline));
    }

    private List<? extends ContextHandler<? extends PipelineContext>> toPipeline(
            Map.Entry<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>> entry) {
        return entry.getValue()
                    .stream()
                    .map(applicationContext::getBean)
                    .collect(Collectors.toList());
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
