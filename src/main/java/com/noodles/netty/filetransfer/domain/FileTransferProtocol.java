package com.noodles.netty.filetransfer.domain;

/**
 * @Description: 文件传输协议
 * @Author: noodles
 * @create: 2021-03-09 22:08
 */
public class FileTransferProtocol {

    private Integer transferType;  // 0 请求传输文件 1 文件传输指令 2 文件传输数据
    private Object transferObj;    // 数据对象: (0) FileDescInfo (1) FileBurstInstruct (2)FileBurstData

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Object getTransferObj() {
        return transferObj;
    }

    public void setTransferObj(Object transferObj) {
        this.transferObj = transferObj;
    }
}
