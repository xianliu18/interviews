package com.noodles.aop.test;

import com.noodles.proxy.ASMProxy;
import com.noodles.proxy.ByteBuddyProxy;
import com.noodles.proxy.CglibProxy;
import com.noodles.proxy.JDKProxy;
import com.noodles.proxy.JavassitProxy;
import com.noodles.service.IUserApi;
import com.noodles.service.impl.UserApiImpl;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.AllArguments;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Origin;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.SuperCall;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @ClassName ReflectTest
 * @Description 反射测试类
 * @Author noodles
 * @Date 2021/1/18 16:57
 */
public class ReflectTest {

    @Test
    public void test_reflect() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<UserApiImpl> clazz = UserApiImpl.class;
        Method queryUserInfo = clazz.getMethod("queryUserInfo");
        Object invoke = queryUserInfo.invoke(clazz.newInstance());
        System.out.println(invoke);
    }

    @Test
    public void test_JDKProxy() {
        IUserApi userApi  = JDKProxy.getProxy(IUserApi.class);
        String invoke = userApi.queryUserInfo();
        System.out.println("测试结果：" + invoke);
    }

    @Test
    public void test_CglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        UserApiImpl userApi = (UserApiImpl)cglibProxy.newInstall(new UserApiImpl());
        String invoke = userApi.queryUserInfo();
        System.out.println("CGLIB 测试结果：" + invoke);
    }

    @Test
    public void test_ASMProxy() throws IOException, InstantiationException, IllegalAccessException {
        IUserApi userApi = ASMProxy.getProxy(UserApiImpl.class);
        String invoke = userApi.queryUserInfo();
        System.out.println("ASM 测试结果：" + invoke);
    }

    @Test
    public void test_JavassistProxy() throws IOException, CannotCompileException, NotFoundException, InstantiationException, IllegalAccessException {
        IUserApi userApi = JavassitProxy.getProxy(UserApiImpl.class);
        String invoke = userApi.queryUserInfo();
        System.out.println("Javassist 测试结果：" + invoke);
    }

}
