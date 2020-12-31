package com.noodles.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName HttpServerInitializer
 * @Description
 * @Author noodles
 * @Date 2020/12/31 11:51
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 向管道加入处理器

        // 得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        // 加入netty的编解码器 httpServerCodec， 其中 codec 为 coder 和 decoder的简称
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());

        // 增加自定义 Handler
        pipeline.addLast("MyHttpServerHandler", new HttpServerHandler());
    }
}
