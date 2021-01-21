package com.noodles.jvm.classpath;

import com.noodles.jvm.classpath.impl.WildcardEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description: 类路径解析
 * @Author: noodles
 * @create: 2021-01-21 08:23
 */
public class Classpath {

    private Entry bootstrapClasspath; // 启动类路径
    private Entry extensionClasspath; // 扩展类路径
    private Entry userClasspath;      // 用户类路径

    public Classpath(String jreOption, String cpOption) {
        // 启动类和扩展类
        bootstrapAndExtensionClasspath(jreOption);
        // 用户类路径
        parseUserClasspath(cpOption);
    }

    private void bootstrapAndExtensionClasspath(String jreOption) {

        String jreDir = getJreDir(jreOption);

        // ./jre/lib/*
        String jreLibPath = Paths.get(jreDir, "lib") + File.separator + "*";
        bootstrapClasspath = new WildcardEntry(jreLibPath);

        // ./jre/lib/ext/*
        String jreExtPath = Paths.get(jreDir, "lib", "ext") + File.separator + "*";
        extensionClasspath = new WildcardEntry(jreExtPath);
    }

    private String getJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }
        if (Files.exists(Paths.get("./jre"))) {
            return "./jre";
        }
        String jh = System.getenv("JAVA_HOME");
        if (jh != null) {
            return Paths.get(jh, "jre").toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }

    private void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = Entry.create(cpOption);
    }

    public byte[] readClass(String className) throws IOException {
        className = className + ".class";

        // [readClass] 启动类路径
        try {
            return bootstrapClasspath.readClass(className);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // [readClass] 扩展类路径
        try {
            return extensionClasspath.readClass(className);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // [readClass] 用户类路径
        return userClasspath.readClass(className);
    }
}
