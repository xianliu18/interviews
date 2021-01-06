package com.noodles.asm.agent;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

/**
 * @Description: 字节码方法
 * @Author: noodles
 * @create: 2021-01-06 22:23
 */
public class MyMonitorTransformer implements ClassFileTransformer {

    public static final Set<String> classNameSet = new HashSet<>();

    static {
        classNameSet.add("com.noodles.netty.test.asm.ApiTest");
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            String currentClassName = className.replace("/", ".");
            if (!classNameSet.contains(currentClassName)) {
                return null;
            }
            System.out.println("Transform: [" + currentClassName + "]");

            CtClass ctClass = ClassPool.getDefault().get(currentClassName);
            CtBehavior[] methods = ctClass.getDeclaredBehaviors();
            for (CtBehavior method : methods) {
                enhanceMethod(method);
            }
            return ctClass.toBytecode();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void enhanceMethod(CtBehavior method) throws CannotCompileException {
        if (method.isEmpty()) {
            return;
        }
        String methodName = method.getName();
        if ("main".equalsIgnoreCase(methodName)) {
            return;
        }

        final StringBuilder source = new StringBuilder();
        // 前置增强: 打入时间戳
        // 保留原有的代码处理逻辑
        source.append("{")
                .append("long start = System.nanoTime();\n")
                .append("$_=$proceed($$);\n")
                .append("System.out.print(\"method:[")
                .append(methodName).append("]\");").append("\n")
                .append("System.out.println(\" cost:[\" + (System.nanoTime() - start) + \"ns]\");")
                .append("}");

        ExprEditor editor = new ExprEditor() {
            @Override
            public void edit(MethodCall methodCall) throws CannotCompileException {
                methodCall.replace(source.toString());
            }
        };
        method.instrument(editor);
    }
}
