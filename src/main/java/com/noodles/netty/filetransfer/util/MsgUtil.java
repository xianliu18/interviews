package com.noodles.netty.filetransfer.util;

import com.noodles.netty.filetransfer.domain.Constants;
import com.noodles.netty.filetransfer.domain.FileBurstData;
import com.noodles.netty.filetransfer.domain.FileBurstInstruct;
import com.noodles.netty.filetransfer.domain.FileDescInfo;
import com.noodles.netty.filetransfer.domain.FileTransferProtocol;

import org.apache.tomcat.util.bcel.Const;

/**
 * @Description: 消息构建工具
 * @Author: noodles
 * @create: 2021-03-09 22:09
 */
public class MsgUtil {

    /**
     * 请求传输文件(客户端)
     */
    public static FileTransferProtocol buildRequestTransferFile(String fileUrl, String fileName, Long fileSize) {

        FileDescInfo fileDescInfo = new FileDescInfo();
        fileDescInfo.setFileUrl(fileUrl);
        fileDescInfo.setFileName(fileName);
        fileDescInfo.setFileSize(fileSize);

        FileTransferProtocol transferProtocol = new FileTransferProtocol();
        transferProtocol.setTransferType(0); // 0 请求传输文件 1 文件传输指令 2 文件传输数据
        transferProtocol.setTransferObj(fileDescInfo);

        return transferProtocol;
    }

    /**
     * 文件传输指令 (服务端)
     * @param status
     * @param clientFileUrl
     * @param readPosition
     * @return
     */
    public static FileTransferProtocol buildTransferInstruct(Integer status, String clientFileUrl, Integer readPosition) {

        FileBurstInstruct instruct = new FileBurstInstruct();
        instruct.setStatus(status);
        instruct.setClientFileUrl(clientFileUrl);
        instruct.setReadPosition(readPosition);

        FileTransferProtocol transferProtocol = new FileTransferProtocol();
        transferProtocol.setTransferType(Constants.TransferType.INSTRUCT); //0 传输文件请求 1 文件传输指令 2 文件传输数据
        transferProtocol.setTransferObj(instruct);

        return transferProtocol;
    }

    /**
     * 文件传输指令 (服务端)
     * @param instruct
     * @return
     */
    public static FileTransferProtocol buildTransferInstruct(FileBurstInstruct instruct) {
        FileTransferProtocol transferProtocol = new FileTransferProtocol();
        transferProtocol.setTransferType(Constants.TransferType.INSTRUCT);
        transferProtocol.setTransferObj(instruct);
        return transferProtocol;
    }

    /**
     * 文件传输数据 (客户端)
     * @param fileBurstData
     * @return
     */
    public static FileTransferProtocol buildTransferData(FileBurstData fileBurstData) {
        FileTransferProtocol transferProtocol = new FileTransferProtocol();
        transferProtocol.setTransferType(Constants.TransferType.DATA);
        transferProtocol.setTransferObj(fileBurstData);
        return transferProtocol;
    }
}
