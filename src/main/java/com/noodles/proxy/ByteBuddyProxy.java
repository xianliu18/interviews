package com.noodles.proxy;

import com.noodles.service.IUserApi;
import com.noodles.service.Station;
import com.noodles.service.impl.StationImpl;
import com.noodles.service.impl.UserApiImpl;
import org.assertj.core.internal.bytebuddy.ByteBuddy;
import org.assertj.core.internal.bytebuddy.description.method.MethodDescription;
import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;
import org.assertj.core.internal.bytebuddy.implementation.MethodDelegation;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.AllArguments;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Origin;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.SuperCall;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @ClassName ByteBuddyProxy
 * @Description Byte-Buddy 代理方式
 * @Author noodles
 * @Date 2021/1/18 19:43
 */
public class ByteBuddyProxy {

    private Station target;

    public ByteBuddyProxy(Station target) {
        this.target = target;
    }

    public Object intercept(@AllArguments Object[] args, @Origin Method method) throws InvocationTargetException, IllegalAccessException {
        System.out.println("手续费");
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        Class<? extends StationImpl> clazz = new ByteBuddy().subclass(StationImpl.class)
                .method(ElementMatchers.nameContainsIgnoreCase("ticket"))
                .intercept(MethodDelegation.to(new ByteBuddyProxy(new StationImpl()))).make()
                .load(StationImpl.class.getClassLoader()).getLoaded();

        try {
            Station obj = clazz.newInstance();
            obj.sellTickets();
            obj.ticketChange();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}

