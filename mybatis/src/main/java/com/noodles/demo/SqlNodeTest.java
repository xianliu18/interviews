package com.noodles.demo;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.MixedSqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName SqlNodeTest
 * @Description SqlNode 测试
 * @Author noodles
 * @Date 2021/3/3 20:52
 */
public class SqlNodeTest {

    @Test
    public void testWhereSqlNode() {
        String sqlFragment = "AND id = #{id}";
        MixedSqlNode msn = new MixedSqlNode(Arrays.asList(new StaticTextSqlNode(sqlFragment)));
        WhereSqlNode wsn = new WhereSqlNode(new Configuration(), msn);
        DynamicContext dc = new DynamicContext(new Configuration(), new MapperMethod.ParamMap<>());
        wsn.apply(dc);
        System.out.println("解析前： " + sqlFragment);
        System.out.println("解析后: " + dc.getSql());
    }
}
