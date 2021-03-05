package com.noodles.demo;

import com.noodles.demo.dao.StudentDao;
import com.noodles.demo.po.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: 不可重复读测试
 * @Author: noodles
 * @create: 2021-03-05 10:56
 */
public class TransactionalCacheTest {

    private SqlSessionFactory sqlSessionFactory;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Before
    public void prepare() throws IOException {
        String resource = "spring/mybatis-config-datasources.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testTransactional() throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        // 开启两个线程
        Future<String> fa = es.submit(this::transactionalA);
        Future<String> fb = es.submit(this::transactionalB);

        countDownLatch.countDown();
        es.awaitTermination(6, TimeUnit.SECONDS);

        System.out.println(fa.get());
        System.out.println("\n -------- 分割线 --------");
        System.out.println(fb.get());
    }

    private String transactionalA() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        countDownLatch.await();

        StringBuilder sb = new StringBuilder();
        sb.append("时刻1: 开启事务 A\n");
        sb.append("时刻1: 查询记录 A\n");

        Student s1 = studentDao.findOne(1);
        sb.append(s1).append("\n");

        sb.append("时刻3: 更新记录 A\n");
        studentDao.update(1, "李大脑袋");
        sb.append("时刻4: 查询记录 A\n");
        Student s2 = studentDao.findOne(1);
        sb.append(s2).append("\n");

        // 此时睡眠 1秒, 让事务 B 在事务 A 提交前, 完成时刻 4的查询请求
        Thread.sleep(1000);

        sb.append("时刻5: 提交事务 A");
        sqlSession.commit();

        return sb.toString();
    }

    private String transactionalB() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        countDownLatch.await();

        StringBuilder sb = new StringBuilder();
        sb.append("时刻1: 开启事务 B\n");
        sb.append("时刻2: 查询数据 A\n");
        Student s1 = studentDao.findOne(1);
        sb.append(s1).append("\n");

        sb.append("时刻3: --------\n");
        sb.append("时刻4: 查询数据 A\n");
        Student s2 = studentDao.findOne(1);
        sb.append(s2).append("\n");

        // 睡眠 3 秒, 等待事务 A 提交
        Thread.sleep(3000);

        sb.append("时刻5: ------\n");
        sb.append("时刻6: 查询数据 A\n");
        Student s3 = studentDao.findOne(1);
        sb.append(s3).append("\n");

        sb.append("时刻7: 提交事务 B\n");
        sqlSession.commit();
        return sb.toString();

    }
}
