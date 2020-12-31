package com.noodles.netty.inboundAndOutbound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


/**
 * @ClassName BoundClientInitializer
 * @Description 客户端intializer
 * @Author noodles
 * @Date 2020/12/31 19:12
 */
public class BoundClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new BoundClientHandler());
    }
}
