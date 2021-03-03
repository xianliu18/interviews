package com.noodles.demo;

import com.noodles.demo.dao.ArticleMapper;
import com.noodles.demo.po.Article;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName PatamNameResolverTest
 * @Description ParamNameResolver 测试
 * @Author noodles
 * @Date 2021/3/3 19:24
 */
public class PatamNameResolverTest {

    @Test
    public void test() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Configuration configuration = new Configuration();
        configuration.setUseActualParamName(false);
        Method method = ArticleMapper.class.getMethod("select", Integer.class, String.class, RowBounds.class, Article.class);

        ParamNameResolver resolver = new ParamNameResolver(configuration, method);
        Field field = resolver.getClass().getDeclaredField("names");
        field.setAccessible(true);
        // 通过反射，获取 ParamNameResolver 私有成员变量 names
        Object names = field.get(resolver);

        System.out.println("names -> " + names);
    }
}
