package com.noodles.netty.filetransfer.domain;

/**
 * @Description: 文件分片数据
 * @Author: noodles
 * @create: 2021-03-09 22:08
 */
public class FileBurstData {

    private String fileUrl;    // 客户端文件地址
    private String fileName;   // 文件名称
    private Integer beginPos;  // 开始位置
    private Integer endPos;    // 结束位置
    private byte[] bytes;      // 文件字节, 实际应用中可以使用非对称加密,以保证传输信息安全
    private Integer status;    // Constants.FileStatus  (0 开始, 1 中间 2 结尾 3 完成)

    public FileBurstData() {
    }

    public FileBurstData(Integer status) {
        this.status = status;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public Integer getEndPos() {
        return endPos;
    }

    public void setEndPos(Integer endPos) {
        this.endPos = endPos;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
