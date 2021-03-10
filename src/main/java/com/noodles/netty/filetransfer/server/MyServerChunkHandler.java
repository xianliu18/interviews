package com.noodles.netty.filetransfer.server;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.handler.stream.ChunkedStream;
import io.netty.util.ReferenceCountUtil;

/**
 * @ClassName MyServerChunkHandler
 * @Description 文件分块处理器
 * @Author noodles
 * @Date 2021/3/10 10:44
 */
public class MyServerChunkHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        // 数据校验
        if (!(msg instanceof ByteBuf)) {
            super.write(ctx, msg, promise);
            return;
        }
        // 获取 byte
        ByteBuf buf = (ByteBuf)msg;
        byte[] data = this.getData(buf);
        // 写入流中
        ByteInputStream in = new ByteInputStream();
        in.setBuf(data);
        // 消息分块：暂定10个字节
        ChunkedStream stream = new ChunkedStream(in, 10);
        // 管道消息传输
        ChannelProgressivePromise progressivePromise = ctx.channel().newProgressivePromise();
        progressivePromise.addListener(new ChannelProgressiveFutureListener() {
            @Override
            public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {

            }

            @Override
            public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("消息发送成功 success");
                    promise.setSuccess();
                } else {
                    System.out.println("消息发送失败 failure:" + future.cause());
                    promise.setFailure(future.cause());
                }
            }
        });
        ReferenceCountUtil.release(msg);
        ctx.write(stream, progressivePromise);
    }

    // 获取 byte
    private byte[] getData(ByteBuf buf) {
        if (buf.hasArray()) {
            return buf.array().clone();
        }
        byte[] data = new byte[buf.readableBytes() - 1];
        buf.readBytes(data);
        return data;
    }
}
