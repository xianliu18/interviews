package com.noodles.jvm;

import com.noodles.jvm.classpath.Classpath;
import com.noodles.jvm.classpath.classfile.ClassFile;

/**
 * @Description: 主类
 * @Author: noodles
 * @create: 2021-01-21 08:22
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath: %s class: %s args: %s\n",
                classpath, cmd.getMainClass(), cmd.getAppArgs());
        // 获取className
        String className = cmd.getMainClass().replace(".", "/");
//        ClassFile classFile = loadClass(className, classpath);
//        assert classFile != null;
//        printClassInfo(classFile);
    }


}
