package com.noodles.netty.codec2;

import com.noodles.netty.codec.StudentPOJO;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @ClassName NettyServerHandler
 * @Description 自定义Handler
 * @Author noodles
 * @Date 2020/12/30 19:26
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        // 根据 dataType， 来显示不同的信息
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == MyDataInfo.MyMessage.DataType.StudentType) {

            MyDataInfo.Student student = msg.getStudent();
            System.out.println("学生id： " + student.getId() + " 学生名字 name: " + student.getName());

        } else if (dataType == MyDataInfo.MyMessage.DataType.WorkerType) {

            MyDataInfo.Worker worker = msg.getWorker();
            System.out.println("工人名字： " + worker.getName() + " 工人年龄: " + worker.getAge());

        } else {
            System.out.println("传输的类型不正确");
        }
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
