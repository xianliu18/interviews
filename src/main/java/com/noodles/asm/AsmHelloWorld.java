package com.noodles.asm;

import jdk.internal.org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName AsmHelloWord
 * @Description 字节码编写helloWorld
 * @Author noodles
 * @Date 2021/1/6 17:18
 */
public class AsmHelloWorld extends ClassLoader {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 生成二进制字节码
        byte[] bytes = generate();
        // 输出字节码
        outputClazz(bytes);
        // 加载MyAsmHelloWorld
        Class<?> clazz = new AsmHelloWorld().defineClass("com.noodles.asm.MyAsmHelloWorld", bytes, 0, bytes.length);
        // 反射获取 main 方法
        Method main = clazz.getMethod("main", String[].class);
        // 调用 main 方法
        main.invoke(null, new Object[]{new String[]{}});

    }

    private static byte[] generate() {
        ClassWriter classWriter = new ClassWriter(0);
        // 定义对象头：版本号，修饰符，全类名，签名，父类，实现的接口
        classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "com/noodles/asm/MyAsmHelloWorld", null, "java/lang/Object", null);
        // 添加方法：修饰符，方法名，描述符，签名，异常
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        // 执行指令：获取静态属性
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        // 加载常量 load constant
        methodVisitor.visitLdcInsn("Hello World ASM!");
        // 调用方法
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        // 返回
        methodVisitor.visitInsn(Opcodes.RETURN);
        // 设置操作数栈的深度和局部变量的大小
        methodVisitor.visitMaxs(2, 1);
        // 方法结束
        methodVisitor.visitEnd();
        // 类完成
        classWriter.visitEnd();
        // 生成字节数组
        return classWriter.toByteArray();
    }

    private static void outputClazz(byte[] bytes) {
        // 输出类字节码
        FileOutputStream out = null;
        try {
            String pathName = AsmHelloWorld.class.getResource("/").getPath() + "MyAsmHelloWorld.class";
            out = new FileOutputStream(new File(pathName));
            System.out.println("ASM类输出路径：" + pathName);
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
