package com.noodles.netty.codec2;

import com.noodles.netty.codec.StudentPOJO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.Random;

/**
 * @ClassName NettyClientHandler
 * @Description 客户端handler
 * @Author noodles
 * @Date 2020/12/30 19:44
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    // 当通道就绪后，就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 随机的发送 Student 或者 Worker 对象
        int random = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        if (0 == random) { // 发送 Student 对象
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.StudentType)
                                .setStudent(MyDataInfo.Student.newBuilder().setId(5).setName("李四").build()).build();
        } else { // 发送 Worker 对象
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.WorkerType)
                                .setWorker(MyDataInfo.Worker.newBuilder().setAge(20).setName("打工人")).build();
        }
        ctx.writeAndFlush(myMessage);
    }

    // 当通道有读取事件时，会触发
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("服务器的回复消息为：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器地址为：" + ctx.channel().remoteAddress());
    }


    // 异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
