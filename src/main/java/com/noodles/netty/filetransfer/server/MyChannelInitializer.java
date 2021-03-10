package com.noodles.netty.filetransfer.server;

import com.noodles.netty.codec3_protostuff.codec.ObjDecoder;
import com.noodles.netty.codec3_protostuff.codec.ObjEncoder;
import com.noodles.netty.filetransfer.domain.FileTransferProtocol;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Description: Channel初始器
 * @Author: noodles
 * @create: 2021-03-09 22:09
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 对象处理
        pipeline.addLast(new ObjDecoder(FileTransferProtocol.class));
        pipeline.addLast(new ObjEncoder(FileTransferProtocol.class));
        // 流量分块处理
//        pipeline.addLast(new ChunkedWriteHandler());
//        pipeline.addLast(new MyServerChunkHandler());
        // 自定义handler
        pipeline.addLast(new MyServerHandler());
    }
}
