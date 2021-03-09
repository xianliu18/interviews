package com.noodles.netty.filetransfer.client;


import com.noodles.netty.filetransfer.codec.ObjDecoder;
import com.noodles.netty.filetransfer.codec.ObjEncoder;
import com.noodles.netty.filetransfer.domain.FileTransferProtocol;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


/**
 * @Description: 客户端启动器
 * @Author: noodles
 * @create: 2021-03-09 22:07
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 对象传输处理
        pipeline.addLast(new ObjDecoder(FileTransferProtocol.class));
        pipeline.addLast(new ObjEncoder(FileTransferProtocol.class));
        // 自定义处理器
        pipeline.addLast(new MyClientHandler());

    }
}
