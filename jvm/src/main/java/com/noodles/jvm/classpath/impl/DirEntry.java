package com.noodles.jvm.classpath.impl;

import com.noodles.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description: 目录形式路径
 * @Author: noodles
 * @create: 2021-01-21 08:24
 */
public class DirEntry implements Entry {

    private Path absolutePath;

    public DirEntry(String path) {
        // 获取绝对路径
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}
