package com.noodles.netty.filetransfer.server;

import com.alibaba.fastjson.JSON;
import com.noodles.netty.filetransfer.domain.Constants;
import com.noodles.netty.filetransfer.domain.FileBurstData;
import com.noodles.netty.filetransfer.domain.FileBurstInstruct;
import com.noodles.netty.filetransfer.domain.FileDescInfo;
import com.noodles.netty.filetransfer.domain.FileTransferProtocol;
import com.noodles.netty.filetransfer.util.CacheUtil;
import com.noodles.netty.filetransfer.util.FileUtil;
import com.noodles.netty.filetransfer.util.MsgUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Description: 自定义handler
 * @Author: noodles
 * @create: 2021-03-09 22:09
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel)ctx.channel();
        System.out.println("链接报告信息： 新增客户端，ChannelId： " + channel.id());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开链接：" + ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 数据格式校验
        if (!(msg instanceof FileTransferProtocol)) {
            return;
        }

        FileTransferProtocol transferProtocol = (FileTransferProtocol)msg;
        // 0 传输文件'请求'
        // 1 文件传输'指令'
        // 2 文件传输'数据'
        switch (transferProtocol.getTransferType()) {
            case 0:
                FileDescInfo descInfo = (FileDescInfo)transferProtocol.getTransferObj();

                // 断点续传信息
                FileBurstInstruct burstInstructOld = CacheUtil.burstDataMap.get(descInfo.getFileName());
                if (null != burstInstructOld) {
                    if (burstInstructOld.getStatus() == Constants.FileStatus.COMPLETE) {
                        CacheUtil.burstDataMap.remove(descInfo.getFileName());
                    }
                    // 传输完成，删除断点信息
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收客户端传输文件请求[断点续传]。" + JSON.toJSONString(burstInstructOld));
                    ctx.writeAndFlush(MsgUtil.buildTransferInstruct(burstInstructOld));
                    return;
                }

                // 发送信息
                FileTransferProtocol sendFileTransferProtocol = MsgUtil.buildTransferInstruct(Constants.FileStatus.BEGIN, descInfo.getFileUrl(), 0);
                ctx.writeAndFlush(sendFileTransferProtocol);
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收客户端传输文件请求。" + JSON.toJSONString(descInfo));
                break;
            case 2:
                FileBurstData burstData = (FileBurstData)transferProtocol.getTransferObj();
                FileBurstInstruct instruct = FileUtil.writeFile("D://", burstData);

                // 保存断点续传信息
                CacheUtil.burstDataMap.put(burstData.getFileName(), instruct);

                ctx.writeAndFlush(MsgUtil.buildTransferInstruct(instruct));
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收客户端传输文件数据。" + JSON.toJSONString(burstData));

                // 传输完成，删除断点信息
                if (instruct.getStatus() == Constants.FileStatus.COMPLETE) {
                    CacheUtil.burstDataMap.remove(burstData.getFileName());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息：\r\n" + cause.getMessage());
    }
}
