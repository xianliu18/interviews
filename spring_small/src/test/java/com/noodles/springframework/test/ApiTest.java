package com.noodles.springframework.test;

import com.noodles.springframework.aop.AdvisedSupport;
import com.noodles.springframework.aop.MethodMatcher;
import com.noodles.springframework.aop.TargetSource;
import com.noodles.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.noodles.springframework.aop.framework.Cglib2AopProxy;
import com.noodles.springframework.aop.framework.JdkDynamicAopProxy;
import com.noodles.springframework.aop.framework.ReflectiveMethodInvocation;
import com.noodles.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import com.noodles.springframework.beans.PropertyValue;
import com.noodles.springframework.beans.PropertyValues;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import com.noodles.springframework.beans.factory.config.BeanPostProcessor;
import com.noodles.springframework.beans.factory.config.BeanReference;
import com.noodles.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.noodles.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.noodles.springframework.context.support.ClassPathXmlApplicationContext;
import com.noodles.springframework.test.bean.CustomerService;
import com.noodles.springframework.test.bean.CustomerServiceInterceptor;
import com.noodles.springframework.test.bean.ICustomerService;
import com.noodles.springframework.test.bean.UserService;
import com.noodles.springframework.test.common.MyBeanFactoryPostProcessor;
import com.noodles.springframework.test.common.MyBeanPostProcessor;
import com.noodles.springframework.test.event.CustomEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 测试类
 * @author: liuxian
 * @date: 2022-11-11 15:20
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1, 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
//        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3, UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "10003"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4, UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3, 第一次获取 Bean
        UserService userService = (UserService)beanFactory.getBean("userService", "abc");
        userService.queryUserInfo();

    }

    @Test
    public void test_xml() {
        // 1, 初始化 BeeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2, 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3, 获取 Bean 对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_noApplicationContext() {
        // 1, 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2, 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3, BeanDefinition 加载完成 & Bean 实例化之前，修改 BeanDefiniton 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4, Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5, 获取 bean 对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_withAppContext() {
        // 1, 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("withAppContext 测试结果：" + result);
    }

    @Test
    public void test_aware() {
        // 1, 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("aware 测试结果：" + result);
//        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
//        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }

    @Test
    public void test_prototype() {
        // 1, 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 获取 Bean 对象调用方法
        UserService service01 = applicationContext.getBean("userService", UserService.class);
        UserService service02 = applicationContext.getBean("userService", UserService.class);

        // 3, 验证 scope
        System.out.println(service01);
        System.out.println(service02);

        System.out.println(service01 + " 十六进制哈希：" + Integer.toHexString(service01.hashCode()));
        System.out.println(ClassLayout.parseInstance(service01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1, 初始化 Beanfactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        // 1， 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        ICustomerService customerService = new CustomerService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(customerService));
        advisedSupport.setMethodInterceptor(new CustomerServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.noodles.springframework.test.bean.ICustomerService.*(..))"));

        // JDK 代理对象
        ICustomerService proxy_jdk = (ICustomerService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println(proxy_jdk.getClass());
        System.out.println("JDK 测试结果：" + proxy_jdk.queryUserInfo() + "\r\n");

        // Cglib 代理对象
        ICustomerService proxy_cglib = (ICustomerService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println(proxy_cglib.getClass());
        System.out.println("Cglib 测试结果：" + proxy_cglib.register("鲁智深"));
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* com.noodles.springframework.test.bean.ICustomerService.*(..))");
        Class<UserService> uclazz = UserService.class;
        Class<CustomerService> custclazz = CustomerService.class;
        Method uMethod = uclazz.getDeclaredMethod("queryUserInfo");
        Method cMethod = custclazz.getDeclaredMethod("queryUserInfo");

        System.out.println("与 UserService 比较：" + pointcut.matches(uclazz));
        System.out.println("与 CustomerService 比较：" + pointcut.matches(custclazz));
        System.out.println("UserService 方法比较：" + pointcut.matches(uMethod, uclazz));
        System.out.println("CustomerService 方法比较：" + pointcut.matches(cMethod, custclazz));
    }

    @Test
    public void test_aop02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        ICustomerService customerService = applicationContext.getBean("customerService", ICustomerService.class);
        System.out.println("测试结果：" + customerService.queryUserInfo());
    }

    @Test
    public void test_proxy_method() {
        // 目标对象
        Object targetObject = new CustomerService();

        // AOP 代理
        ICustomerService proxy = (ICustomerService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObject.getClass().getInterfaces(), new InvocationHandler() {
                   // 方法匹配器
                    MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.noodles.springframework.test.bean.ICustomerService.*(..))");
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (methodMatcher.matches(method, targetObject.getClass())) {
                            // 方法拦截器
                            MethodInterceptor methodInterceptor = invocation -> {
                                long start = System.currentTimeMillis();
                                try {
                                    return invocation.proceed();
                                } finally {
                                    System.out.println("监控 - Begin By AOP");
                                    System.out.println("方法名称：" + invocation.getMethod().getName());
                                    System.out.println("方法耗时：" + (System.currentTimeMillis() - start));
                                    System.out.println("监控 - End\r\n");
                                }
                            };
                            // 反射调用
                            return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObject, method, args));
                        }
                        return method.invoke(targetObject, args);
                    }
                });

        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
