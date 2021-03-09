package com.noodles.netty.threadpool;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName NettyServerHandler
 * @Description 自定义Handler
 * @Author noodles
 * @Date 2020/12/30 19:26
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // 业务线程池，即将业务提交到该线程池
    static final EventExecutorGroup group = new DefaultEventExecutorGroup(16);

    // 读取客户端发送的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        // 打印当前线程名称
        System.out.println("NettyServerHandler channelRead 线程：" + Thread.currentThread().getName());

        // 1, 用户自定义普通任务
        // 异步执行  耗时任务，即将该任务提交给 channel 对应的 NIOEventLoop 的 taskQueue 中
//        ctx.channel().eventLoop().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10 * 1000);
//                    // 输出线程名
//                    System.out.println("NettyServerHandler execute 线程： " + Thread.currentThread().getName());
//                    ctx.writeAndFlush(Unpooled.copiedBuffer("耗时任务执行完成。", CharsetUtil.UTF_8));
//                } catch (InterruptedException e) {
//                    System.out.println("执行任务出现异常" + e.getMessage());
//                }
//            }
//        });
        // 提交到线程池执行
        group.submit(() -> {
           // 接收客户端消息
            ByteBuf buf = (ByteBuf)msg;
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            try {
                String body = new String(bytes, "UTF-8");
                // 休眠 10 秒
                Thread.sleep(10 * 1000);
                System.out.println("group.submit 的 call线程： " + Thread.currentThread().getName());
                ctx.writeAndFlush(Unpooled.copiedBuffer("客户端早上好~~", CharsetUtil.UTF_8));
            } catch (UnsupportedEncodingException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("go on...");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("This is a test from server", CharsetUtil.UTF_8));
    }

    // 处理异常，关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

}
