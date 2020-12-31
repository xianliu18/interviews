package com.noodles.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName NettyServerHandler
 * @Description 自定义Handler
 * @Author noodles
 * @Date 2020/12/30 19:26
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /*
     * 1, 自定义Handler需要继承netty的某个HandlerAdapter
     * 2, 这时，自定义的Handler，才能称为Handler
     */

    // 读取客户端发送的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

//        // 打印当前线程名称
//        System.out.println("服务器读取线程：" + Thread.currentThread().getName());
//
//        // ByteBuf 是 Netty 提供
//        ByteBuf buf = (ByteBuf)msg;
//        System.out.println("客户端发送的消息是：" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址为: " + ctx.channel().remoteAddress());

        /*
         * 任务队列中的Task 三种典型使用场景
         *     1，用户程序自定义的普通任务
         *     2，自定义定时任务
         *     3，非当前Reactor线程调用Channel的各种方法
         */
        // 1, 用户自定义普通任务
        // 异步执行  耗时任务，即将该任务提交给 channel 对应的 NIOEventLoop 的 taskQueue 中
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("耗时任务执行完成。", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("执行任务出现异常" + e.getMessage());
                }
            }
        });


        // 2, 用户自定义定时任务 -》 任务提交到 scheduledTaskQueue 中
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                ctx.writeAndFlush(Unpooled.copiedBuffer("执行定时任务完成。", CharsetUtil.UTF_8));
            }
        }, 5, TimeUnit.SECONDS);


        System.out.println("go on...");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("This is a test from server", CharsetUtil.UTF_8));
    }

    // 处理异常，关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
