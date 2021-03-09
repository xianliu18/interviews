package com.noodles.netty.filetransfer.domain;

/**
 * @Description: 文件分片指令
 * @Author: noodles
 * @create: 2021-03-09 22:08
 */
public class FileBurstInstruct {

    private Integer status;    // Constants.FileStatus
    private String clientFileUrl; // 客户端文件URL
    private Integer readPosition; // 读取位置

    public FileBurstInstruct() {
    }

    public FileBurstInstruct(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClientFileUrl() {
        return clientFileUrl;
    }

    public void setClientFileUrl(String clientFileUrl) {
        this.clientFileUrl = clientFileUrl;
    }

    public Integer getReadPosition() {
        return readPosition;
    }

    public void setReadPosition(Integer readPosition) {
        this.readPosition = readPosition;
    }
}
