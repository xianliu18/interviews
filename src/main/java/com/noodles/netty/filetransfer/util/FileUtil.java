package com.noodles.netty.filetransfer.util;

import com.noodles.netty.filetransfer.domain.Constants;
import com.noodles.netty.filetransfer.domain.FileBurstData;
import com.noodles.netty.filetransfer.domain.FileBurstInstruct;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description:
 * @Author:
 * @create: 2021-03-09 22:09
 */
public class FileUtil {

    public static FileBurstData readFile(String fileUrl, Integer readPosition) throws IOException {
        File file = new File(fileUrl);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.seek(readPosition);
        byte[] bytes = new byte[1024 * 100];
        int readSize = randomAccessFile.read(bytes);
        if (readSize <= 0) {
            randomAccessFile.close();
            return new FileBurstData(Constants.FileStatus.COMPLETE);
        }
        FileBurstData fileInfo = new FileBurstData();
        fileInfo.setFileUrl(fileUrl);
        fileInfo.setFileName(file.getName());
        fileInfo.setBeginPos(readPosition);
        fileInfo.setEndPos(readPosition + readSize);
        // 不足1024, 拷贝时,需要去掉空字节
        if (readSize < 1024 * 100) {
            byte[] copy = new byte[readSize];
            System.arraycopy(bytes, 0, copy, 0, readSize);
            fileInfo.setBytes(copy);
            fileInfo.setStatus(Constants.FileStatus.END);
        } else {
            fileInfo.setBytes(bytes);
            fileInfo.setStatus(Constants.FileStatus.CENTER);
        }
        randomAccessFile.close();
        return fileInfo;
    }

    public static FileBurstInstruct writeFile(String baseUrl, FileBurstData fileBurstData) throws IOException {
        if (Constants.FileStatus.COMPLETE == fileBurstData.getStatus()) {
            return new FileBurstInstruct(Constants.FileStatus.COMPLETE);
        }

        File file = new File(baseUrl + "/" + fileBurstData.getFileName());
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(fileBurstData.getBeginPos());
        randomAccessFile.write(fileBurstData.getBytes());
        randomAccessFile.close();

        if (Constants.FileStatus.END == fileBurstData.getStatus()) {
            return new FileBurstInstruct(Constants.FileStatus.COMPLETE);
        }

        // 文件分片传输指令
        FileBurstInstruct instruct = new FileBurstInstruct();
        instruct.setStatus(Constants.FileStatus.CENTER);
        instruct.setClientFileUrl(fileBurstData.getFileUrl());
        instruct.setReadPosition(fileBurstData.getEndPos());

        return instruct;
    }
}
