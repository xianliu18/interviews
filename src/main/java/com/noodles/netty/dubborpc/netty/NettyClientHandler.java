package com.noodles.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @ClassName NettyClientHandler
 * @Description 业务handler
 * @Author noodles
 * @Date 2021/3/9 9:42
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context; // 上下文
    private String result; // 返回的结果
    private String para; // 传入的参数

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = (String)msg;
        notify();  // 唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    // 被代理对象调用，发送数据给服务器 ---》 等待唤醒(wait)
    @Override
    public synchronized Object call() throws Exception {

        context.writeAndFlush(para);

        wait(); // 等待 ChannelRead 方法获取到服务器的结果后，唤醒

        return result; // 服务方返回的结果
    }

    void setPara(String para) {
        this.para = para;
    }
}
