package com.noodles.asm.sum;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName AsmSum
 * @Description 使用字节码求两数之和
 * @Author noodles
 * @Date 2021/1/6 17:46
 */
public class AsmSum extends ClassLoader{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 生成二进制字节码
        byte[] bytes = generate();
        // 输出字节码
        outputClazz(bytes);
        // 加载MyAsmSumOfTwo
        Class<?> clazz = new AsmSum().defineClass("com.noodles.asm.sum.MyAsmSumOfTwo", bytes, 0, bytes.length);
        // 反射获取 main 方法
        Method main = clazz.getMethod("main", String[].class);
        // 调用 main 方法
        main.invoke(null, new Object[]{new String[]{}});

    }

    private static byte[] generate() {
        ClassWriter classWriter = new ClassWriter(0);
        // 生成空的构造函数
        {
            MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        // 定义对象头：版本号，修饰符，全类名，签名，父类，实现的接口
        classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "com/noodles/asm/sum/MyAsmSumOfTwo", null, "java/lang/Object", null);
        // 添加方法：修饰符，方法名，描述符，签名，异常
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        methodVisitor.visitTypeInsn(Opcodes.NEW, "com/noodles/asm/sum/MyAsmSumOfTwo");
        methodVisitor.visitInsn(Opcodes.DUP);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/noodles/asm/sum/MyAsmSumOfTwo", "<init>", "()V");
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitInsn(Opcodes.ICONST_2);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "com/noodles/asm/sum/MyAsmSumOfTwo", "sum", "(II)I");
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 1);
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V");
        // 返回
        methodVisitor.visitInsn(Opcodes.RETURN);

        // 设置操作数栈的深度和局部变量大小
        methodVisitor.visitMaxs(3, 2);
        // 方法结束
        methodVisitor.visitEnd();

        /**
         * public int sum(int i, int m) {
         *     return i + m;
         * }
         */
        MethodVisitor methodVisitor_sum = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sum", "(II)I", null, null);
        methodVisitor_sum.visitVarInsn(Opcodes.ILOAD, 1);
        methodVisitor_sum.visitVarInsn(Opcodes.ILOAD, 2);
        methodVisitor_sum.visitInsn(Opcodes.IADD);
        // 返回
        methodVisitor_sum.visitInsn(Opcodes.IRETURN);
        // 设置操作数栈的深度和局部变量大小
        methodVisitor_sum.visitMaxs(2,3);
        methodVisitor_sum.visitEnd();

        // 类完成
        classWriter.visitEnd();
        // 生成字节数组
        return classWriter.toByteArray();
    }

    private static void outputClazz(byte[] bytes) {
        // 输出类字节码
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("MyAsmSumOfTwo.class");
            System.out.println("ASM 类输出路径：" + (new File("")).getAbsolutePath());
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
