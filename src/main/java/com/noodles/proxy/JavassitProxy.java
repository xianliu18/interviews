package com.noodles.proxy;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * @ClassName JavassitProxy
 * @Description Javassist 代理
 * @Author noodles
 * @Date 2021/1/18 21:07
 */
public class JavassitProxy extends ClassLoader {

    public static <T> T getProxy(Class clazz) throws NotFoundException, CannotCompileException, IOException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        // 获取类
        CtClass ctClass = pool.get(clazz.getName());
        // 获取方法
        CtMethod ctMethod = ctClass.getDeclaredMethod("queryUserInfo");
        // 方法前加强
        ctMethod.insertBefore("{System.out.println(\"" + ctMethod.getName() + " 被代理了， By Javassist\");}");

        byte[] bytes = ctClass.toBytecode();

        return (T)new JavassitProxy().defineClass(clazz.getName(), bytes, 0, bytes.length).newInstance();
    }
}
