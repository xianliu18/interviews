package com.noodles.netty.codec3_protostuff.server;

import com.noodles.netty.codec3_protostuff.codec.ObjDecoder;
import com.noodles.netty.codec3_protostuff.codec.ObjEncoder;
import com.noodles.netty.codec3_protostuff.domain.MsgInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName MyChannelInitializer
 * @Description server 端 channel 初始化程序
 * @Author noodles
 * @Date 2021/3/9 16:48
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 对象传输处理
        pipeline.addLast(new ObjDecoder(MsgInfo.class));
        pipeline.addLast(new ObjEncoder(MsgInfo.class));
        // 自定义处理器
        pipeline.addLast(new MyServerHandler());
    }
}
