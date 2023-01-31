### 1. 概述

本项目是以[小傅哥的博客](https://bugstack.cn/itstack/interview.html)为蓝本整理出来的，面向高级程序员的一份学习资料。

阅读本文之前，请先阅读《[How To Ask Questions The Smart Way(中文版)](https://github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way/blob/main/README-zh_CN.md)》。

阅读建议：<br/>
1，实践出真知
- 我的初中数学老师曾在数学复习课中讲过，你得在纸上写写划划，自己写一遍演算过程，才能学会。只是瞪眼看，学不到任何内容，而且还容易犯困。
- 关于代码的学习，也建议你新建一个项目，按照博客中的示例，亲身在IDE中敲一遍，运行一下，验证一下结果。

2，建议阅读三遍
- 这些博客是写作者多年经验的总结。由于自己没有真正的遇到过相应问题，当阅读第一遍完成时，只能达到“虚假”的理解层次；换句话说，引用的博客作者们是站在地上十八层进行写作的，而当下的自己是站在地下十八层阅读的。因此，并不是阅读一遍就可以跨越这么大的层次。
- 本文的信息密度较大，由于[艾宾浩斯遗忘曲线](https://baike.baidu.com/item/遗忘曲线)的存在，会产生读完后面，忘记前面的情况，这属于正常情况；
- 当你阅读完第三遍时，相信会达到“一览众山小”境界；

最后，以人生三境界结束概述：`看山是山；看山不是山；看山是山`。

由于本人的写作水平和能力有限，文中难免存在不妥之处，欢迎大家通过邮箱与我联系，邮箱地址：isliuxian@163.com

<br/>

----------- 概述 完 ----------

<br/>

### 0. Java 基础
1. [基本数据类型](#0.1)
2. [三大特性：封装，继承，多态](#0.2)
3. [抽象类和接口](#0.3)
4. [Java 异常分类](#0.4)

#### 0.1 <span id="0.1">基本数据类型</span>
- 基本数据类型：
  - `byte`: -128 ~ 127
  - `short`: -2^15 ~ 2^15 - 1
  - `int`: -2^31 ~ 2^31 - 1
  - `long`: -2^63 ~ 2^63 - 1
  - `float`
  - `double`
  - `boolean`
  - `char`

#### 0.2 <span id="0.2">三大特性：封装，继承，多态</span>
- [多态](https://www.liaoxuefeng.com/wiki/1252599548343744/1260455778791232)
- [Java 的多态的直观解释](https://www.zhihu.com/question/30082151)
- [Java 的多态（深入版）](https://segmentfault.com/a/1190000021936858)

#### 0.3 <span id="0.3">抽象类和接口</span>
- [深入理解 Java 的接口和抽象类](https://www.cnblogs.com/dolphin0520/p/3811437.html)

#### 0.4 <span id="0.4">Java 异常分类</span>
- [Java 异常分类](https://www.cnblogs.com/niceyoo/p/10585459.html)
- [常见异常类](https://blog.csdn.net/qq_36756682/article/details/102955916)

<br/>

----------- 入门章 完 ----------

<br/>

### 1. JVM 相关内容
1. [JDK，JRE，JVM 关系](#1.1)
2. [JVM 类加载机制](#1.2)
3. [JVM 内存模型](#1.3)
4. [垃圾收集算法及对应实现](#1.4)
5. [JVM 故障处理](#1.5)

<br/>

#### 1.1 <span id="1.1">JDK，JRE，JVM关系</span>
- [JDK-JRE-JVM 是什么关系](https://bugstack.cn/interview/2020/12/23/面经手册-第23篇-JDK-JRE-JVM-是什么关系.html)

#### 1.2 <span id="1.2">JVM 类加载机制</span>
- [new 一个对象，背后发生了什么](https://zhuanlan.zhihu.com/p/257863129)
- [JVM 加载机制：双亲委派模型](https://segmentfault.com/a/1190000021448897)
- [被破坏的双亲委派模型之服务商供应接口Java SPI](https://www.jianshu.com/p/e6f1f89a9e22)

#### 1.3 <span id="1.3">JVM 内存模型</span>
- [图解 JVM 内存布局](https://segmentfault.com/a/1190000021424972)
- [Java 版虚拟机](https://bugstack.cn/interview/2021/01/06/面经手册-第25篇-JVM内存模型总结-有各版本JDK对比-有元空间OOM监控案例-有Java版虚拟机-综合学习更容易.html)

#### 1.4 <span id="1.4">垃圾收集算法及对应实现（垃圾收集器）</span>
- [一次性把Java的四种引用说清楚](https://blog.csdn.net/yasinshaw/article/details/106205353)
- [如何判断对象已死](https://bugstack.cn/interview/2021/01/20/面经手册-第27篇-JVM-判断对象已死-实践验证GC回收.html)
- [经典垃圾收集器](https://zhuanlan.zhihu.com/p/259740590)
- [JVM 垃圾回收](https://segmentfault.com/a/1190000021516052)
<!--
- [理解JVM安全点](https://zhuanlan.zhihu.com/p/286110609)
- [JVM 安全点引起的问题](https://mp.weixin.qq.com/s/KDUccdLALWdjNBrFjVR74Q)
-->

#### 1.5 <span id="1.5">JVM 故障处理</span>
- [JVM 故障处理工具使用总结](https://bugstack.cn/interview/2021/01/13/面经手册-第26篇-JVM故障处理工具-使用总结.html)
- [Minor GC，Full GC，Major GC介绍](https://www.cnblogs.com/cnndevelop/p/12142638.html)
- [JVM 调优](https://www.zhihu.com/question/427461208/answer/2560449750)
- [一次 JVM 内存泄漏问题](https://blog.csdn.net/wenyiCodeDog/article/details/119722179)
- [系统运行缓慢，CPU 100%，以及 Full GC 次数过多问题的排查思路](https://my.oschina.net/zhangxufeng/blog/3017521)
- [频繁 Full GC 问题原因分析](https://blog.csdn.net/weixin_42228338/article/details/98685104)
- [线上 OOM 问题排查](https://blog.csdn.net/qq_16681169/article/details/53296137)
    - `top` 命令, 查看机器CPU以及内存是否正常
    - `jstat -gcutil pid 1000 100` 监控JVM内存运行状况和gc频率
    - `jmap -histo:live pid` 可用统计存活对象的分布情况，找到最耗内存的对象。
    - `jmap -dump:live,format=b,file=dump3.hprof pid` 使用 jmap dump 内存快照。
    - 使用`VisualVM`工具进行分析
<!--
- [聊聊 JStack 工作原理](https://www.cnblogs.com/qingquanzi/p/8974850.html)
-->

<br/>

----------- 第一章 完 ----------

<br/>

### 2. Java 集合相关
1. [String](#2.1)
2. [ArrayList 和 LinkedList](#2.2)
3. [HashMap](#2.3)

#### 2.1 <span id="2.1">String 相关</span>
- [String，StringBuilder，StringBuffer 分析](https://bugstack.cn/interview/2020/09/17/面经手册-第11篇-StringBuilder-比-String-快-空嘴白牙的-证据呢.html)
    - [String 不可改变原因分析](https://www.cnblogs.com/cswiki/p/14628286.html)

#### 2.2 <span id="2.2">ArrayList 和 LinkedList</span>
- [ArrayList 源码分析](https://bugstack.cn/interview/2020/08/27/面经手册-第7篇-ArrayList也这么多知识-一个指定位置插入就把谢飞机面晕了.html)
- [ArrayList 和 LinkedList 性能比较](https://bugstack.cn/interview/2020/08/30/面经手册-第8篇-LinkedList插入速度比ArrayList快-你确定吗.html)
- [CopyOnWriteArrayList 详解](https://segmentfault.com/a/1190000019787913)
- [CopyOnWriteArrayList 利弊总结](https://stefan.blog.csdn.net/article/details/111601912)

#### 2.3 <span id="2.3">HashMap</span>
- [HashMap 扰动函数，负载因子，链表扩容](https://bugstack.cn/interview/2020/08/07/面经手册-第3篇-HashMap核心知识-扰动函数-负载因子-扩容链表拆分-深度学习.html)
    - `resize()中 (e.hash & oldCap) == 0`：是 oldCap，不是 （oldCap - 1）
- [HashMap 数据插入，查找，删除，遍历](https://bugstack.cn/interview/2020/08/13/面经手册-第4篇-HashMap数据插入-查找-删除-遍历-源码分析.html)
- [HashMap 1.7 与 1.8 区别](https://blog.csdn.net/carson_ho/article/details/79373026)
  - [HashMap 不安全](https://coolshell.cn/articles/9606.html)
- [Java 7/8 中的 HashMap 和 ConcurrentHashMap 全解析](https://javadoop.com/post/hashmap)

<br/>

----------- 第二章 完 ----------

<br/>

### 3. 并发编程
1. [Thread 介绍](#3.1)
2. [ThreadLocal 介绍](#3.2)
3. [并发编程基础](#3.3)
4. [volatile 关键字](#3.4)
5. [synchronized 关键字](#3.5)
6. [多线程协作 wait，notify，notifyAll](#3.6)
7. [ReentrantLock](#3.7)
8. [CAS](#3.8)
9. [AQS 讲解(AbstractQueuedSynchronizer)](#3.9)
10. [Semaphore，CountDownLatch，CyclicBarrier](#3.10)
11. [线程池](#3.11)

#### 3.1 <span id="3.1">Thread 介绍</span>
- [Java 中创建线程的方式](https://www.cnblogs.com/noteless/p/10354753.html)
- [Thread.start() 方法调用过程分析](https://bugstack.cn/interview/2020/11/25/面经手册-第19篇-Thread.start()-它是怎么让线程启动的呢.html)
- [Thread 的状态分析](https://www.cnblogs.com/noteless/p/10372674.html)
- [通过代码分析 Thread 的状态](https://bugstack.cn/interview/2020/12/02/面经手册-第20篇-Thread-线程-状态转换-方法使用-原理分析.html)

#### 3.2 <span id="3.2">ThreadLocal 介绍</span>
- [ThreadLocal 源码分析](https://bugstack.cn/interview/2020/09/23/面经手册-第12篇-面试官-ThreadLocal-你要这么问-我就挂了.html)
    - `ThreadLocalDemo6.java`
- [图文深度解析 ThreadLocal](https://juejin.cn/post/6844904151567040519)
- [ThreadLocal 为什么会内存泄漏](https://blog.csdn.net/thewindkee/article/details/89390145)
    - 由于ThreadLocalMap的生命周期跟Thread一样长，当一个ThreadLocal所有强引用都移除且绑定了对应信息的线程还存在时，GC被触发的时候对应Entry里的key被回收后值置为null，value还存在。
- [ThreadLocal 在 Quartz 和 MyBatis 中的应用](https://blog.csdn.net/yasinshaw/article/details/106774620)
- [深入理解 ThreadLocal](https://www.cnblogs.com/noteless/p/10373044.html)
    - [父子线程共享变量：InheritableThreadLocal](https://www.cnblogs.com/noteless/p/10448283.html)
    - [线程池共享变量：TransmittableThreadLocal 原理分析](https://mp.weixin.qq.com/s/1VVu25bzea1jzAWz7fKEUA)
<!--
- [Netty FastThreadLocal 原理分析](https://blog.csdn.net/mycs2012/article/details/90898128)
-->

#### 3.3 <span id="3.3">并发编程基础</span>
- [Java 内存模型JMM，原子性，可见性，有序性简介](https://www.cnblogs.com/noteless/p/10401193.html)

#### 3.4 <span id="3.4">volatile 关键字</span>
- [volatile 实现内存可见性原理](https://bugstack.cn/interview/2020/10/21/面经手册-第14篇-volatile-怎么实现的内存可见-没有-volatile-一定不可见吗.html)
- [图解 volatile 内存屏障](http://concurrent.redspider.group/article/02/8.html)
- [final 关键字与安全发布](https://www.cnblogs.com/noteless/p/10416678.html)

#### 3.5 <span id="3.5">synchronized 关键字</span>
- 基于 JVM 层面的悲观锁
- [synchronized 锁升级过程分析](https://bugstack.cn/interview/2020/10/28/面经手册-第15篇-码农会锁-synchronized-解毒-剖析源码深度分析.html)
- [通过反编译 synchronized 代码，查看其原理](https://www.cnblogs.com/paddix/p/5367116.html)

#### 3.6 <span id="3.6">多线程协作 wait，notify，nofityAll</span>
- [多线程协作 wait，nofity，notifyAll 方法简介](https://www.cnblogs.com/noteless/p/10468834.html)
- [三种让线程等待和唤醒的方法](https://mp.weixin.qq.com/s/I81Ldqr9COA6MyOlRsJARg)
- [sleep，yield 以及 join 方法](https://www.cnblogs.com/noteless/p/10443446.html)
- [Java 锁与监视器](https://www.cnblogs.com/noteless/p/10394054.html)

#### 3.7 <span id="3.7">ReentrantLock</span>
- JDK 层面的悲观锁
- [Lock 接口与 synchronized 关键字对比](https://www.cnblogs.com/noteless/p/10481286.html)
- [Lock 类放在 try 块之内和之外有什么区别？](https://www.zhihu.com/question/54613772)
- [四种自旋锁原理分析(SpinLock，TicketSpinLock，CLH，MCS)](https://stefan.blog.csdn.net/article/details/108750554)

#### 3.8 <span id="3.8">CAS</span>
- [CAS 与原子操作](http://concurrent.redspider.group/article/02/10.html)
<!--
- [Java 自旋锁的几种实现](https://www.cnblogs.com/scholar-hwg/p/12172154.html)
- [ReentrantLock 可重入锁使用](https://zhuanlan.zhihu.com/p/88884729)
- [ReentrantLock 公平锁讲解](https://bugstack.cn/interview/2020/11/04/面经手册-第16篇-码农会锁-ReentrantLock之公平锁讲解和实现.html)
- [Java 魔法类： Usafe 应用解析](https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html)
- [比 AtomicLong 更优秀的 LongAddr 原理分析](https://www.cnblogs.com/wang-meng/p/12892695.html)
-->

#### 3.9 <span id="3.9">AQS 讲解(AbstractQueuedSynchronizer)</span>
- `static final Node SHARED`
- `static final Node EXCLUSIVE`
- `private volatile int state`
- `volatile int waitStatus`: SIGNAL, CANCELLED, CONDITION, PROPAGATE, 0
- `volatile Thread thread`
- [图解 AQS 原理](https://www.cnblogs.com/wang-meng/p/12816829.html)
- [从 ReentrantLock 的实现看 AQS 原理及应用](https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html)

<!--
- [AQS 原理分析和实践使用](https://bugstack.cn/interview/2020/11/11/面经手册-第17篇-码农会锁-ReentrantLock之AQS原理分析和实践使用.html)
- [Condition 实现原理](https://cloud.tencent.com/developer/article/1638926)
- [Condition 实现原理](http://www.tianxiaobo.com/2018/05/04/AbstractQueuedSynchronizer-原理分析-Condition-实现原理/)
- [AQS 独占-共享模式](http://www.tianxiaobo.com/2018/05/01/AbstractQueuedSynchronizer-原理分析-独占-共享模式/)
- [协作式中断 Java 线程](https://blog.csdn.net/yasinshaw/article/details/107328906)
- [多线程中断机制](https://blog.csdn.net/pangpang123654/article/details/77336383)
- [高并发中常见的限流（二）](https://juejin.cn/post/6898897317806800904)
- [图解 ThreadPoolExecutor 线程池原理](https://www.cnblogs.com/wang-meng/p/12945703.html)
- [什么是双端队列-延迟队列-阻塞队列](https://bugstack.cn/interview/2020/09/03/面经手册-第9篇-队列是什么-什么是双端队列-延迟对列-阻塞队列-全是知识盲区.html)
- [Java 线程池实现原理及其在美团业务中的实践](https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html)
- [创建线程池的四种方式](https://bugstack.cn/interview/2020/12/16/面经手册-第22篇-线程池的介绍和使用-以及基于jvmti设计非入侵监控.html)
- [ThreadPoolExecutor 线程池实现原理](https://bugstack.cn/interview/2020/12/09/面经手册-第21篇-手写线程池-对照学习ThreadPoolExecutor线程池实现原理.html)
    - [Worker 为什么要继承 AQS](https://blog.csdn.net/Prior_SX/article/details/124726716)
    - [继承 AQS(二)](https://www.zhihu.com/question/54680390)
- 线程池工作中的配置：
    - spring 的 ThreadPoolTaskExecutor
    - `corePoolSize`, `maxPoolSize`, `keepAliveSeconds`, `queueCapacity(队列长度）`, `异常处理 Handler`
    - `CallerRunsPolicy`：主线程直接执行该任务，执行任务完成之后，尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度。
    - [CallerRunsPolicy 问题](https://blog.csdn.net/lavorange/article/details/118076656)
- [AQS 共享锁，Semaphore，CountDownLatch](https://bugstack.cn/md/java/interview/2020-11-18-面经手册%20·%20第18篇《AQS%20共享锁，Semaphore、CountDownLatch，听说数据库连接池可以用到！》.html)
-->

#### 3.10 <span id="3.10">Semaphore，CountDownLatch，CyclicBarrier</span>
- [不可不说的 Java “锁”事](https://tech.meituan.com/2018/11/15/java-lock.html)
- [CountdownLatch和CyclicBarrier的区别使用场景与具体实现](https://zhuanlan.zhihu.com/p/139020914)
- [CountDownLatch 与 CyclicBarrier 原理分析](http://www.tianxiaobo.com/2018/05/10/Java-线程同步组件-CountDownLatch-与-CyclicBarrier-原理分析/)
- Semaphore 应用场景：限流
  - [高并发中常见的限流方式（一）](https://mp.weixin.qq.com/s/37WkBzmGb4Fevbk4HQEISw)

#### 3.11 <span id="3.11">线程池</span>
- [intertupt interrupted isInterrupted 方法对比](https://www.cnblogs.com/noteless/p/10372826.html)
- [线程池创建方式](https://github.com/xianliu18/ARTS/blob/master/jvm/threadpool/01线程池之Executors创建线程池.md)
- [ThreadPoolExecutor深度解读](https://github.com/xianliu18/ARTS/blob/master/jvm/threadpool/02ThreadPoolExecutor深度解读.md)

<br/>

----------- 第三章 完 ----------

<br/>

### 4. Spring
1. [反射，动态代理](#4.1)
2. [SpringBoot 相关](#4.2)
3. [Spring IOC](#4.3)
4. [Spring AOP](#4.4)
5. [Spring MVC](#4.5)
6. [MyBatis](#4.6)

#### 4.1 <span id = "4.1">反射，动态代理</span>
- [动态代理的五种方式总结](https://bugstack.cn/interview/2020/10/14/面经手册-第13篇-除了JDK-CGLIB-还有3种类代理方式-面试又卡住.html)
- [JDK 和 Cglib 动态代理的实现和区别](https://juejin.cn/post/6857769271737614349)
- [深入梳理 Java 代理机制](https://www.cnblogs.com/cswiki/p/14461856.html)

#### 4.2 <span id = "4.2">SpringBoot 相关</span>
- [SpringBoot 自动装配原理](https://zhuanlan.zhihu.com/p/345895748)
  - [SpringBoot 自动配置原理（一）](https://zhuanlan.zhihu.com/p/55637237)
  - [SpringBoot 自动配置原理（二）](https://www.cnblogs.com/jimoer/p/14131406.html)
  - [Java SPI机制](https://www.jianshu.com/p/e6f1f89a9e22)
  - [Dubbo，JDK 和 Spring SPI 机制比较](https://juejin.cn/post/6950266942875779108)

#### 4.3 <span id = "4.3">Spring IOC</span>
- [@Autowired 和 @Resource 的区别是什么](https://blog.csdn.net/qq_45590494/article/details/114444371)
- [Spring Bean的生命周期](https://blog.csdn.net/weixin_40834464/article/details/82829999)
  - [BeanFactoryPostProcessor 注册时机](https://www.cnblogs.com/xiaoxing/p/10297202.html)
  - [BeanPostProcessor 注册时机](https://www.cnblogs.com/xiaoxing/p/10249232.html)
  - [MapperScannerConfigurer 使用 BeanFactoryPostProcessor](https://www.cnblogs.com/fangjian0423/p/spring-mybatis-MapperScannerConfigurer-analysis.html)
- [Spring Bean 的生命周期（二）](https://zhuanlan.zhihu.com/p/159554995)
  - [Spring IOC 容器构建流程](https://zhuanlan.zhihu.com/p/311373740)
- [三级缓存和循环依赖](https://juejin.cn/post/6930904292958142478)
  - [Spring 是如何解决循环依赖的](https://www.cnblogs.com/jimoer/p/13562707.html)
  - `AbstractAutowireCapableBeanFactory` 中 `doCreateBean` 方法中的 `addSingletonFactory`, `getEarlyBeanReference()`

<!--
- [Spring 初始化 XML 并注册 Bean 流程分析](https://bugstack.cn/itstack-demo-any/2020/01/08/源码分析-像盗墓一样分析Spring是怎么初始化xml并注册bean的.html)
- [SpringBoot SPI 扩展机制（二）](https://www.jianshu.com/p/6756d61b892f)
- [SpringBoot 的 SPI 机制（一）](https://blog.csdn.net/pycharm_u/article/details/108196307)
- [手写 mybatis-spring 核心功能](https://bugstack.cn/itstack-demo-any/2020/01/20/源码分析-手写mybait-spring核心功能(干货好文一次学会工厂bean-类代理-bean注册的使用).html)

- [Spring IOC 容器源码分析](http://www.tianxiaobo.com/2018/05/30/Spring-IOC-容器源码分析系列文章导读/)
  - IOC 导读：`AbstractApplicationContext#refresh()`
  - 获取单例 Bean：`AbstractBeanFactory#getBean(String name)`
  - 创建单例 Bean 的过程：`AbstractAutowireCapableBeanFactory#createBean()`
  - 创建单例 Bean 对象：`AbstractAutowireCapableBeanFactory#createBeanInstance()`
  - 循环依赖的解决办法
  - 填充属性到 Bean 原始对象：`AbstractAutowireCapableBeanFactory#populateBean()`
  - 余下的初始化工作
- [Spring MVC 源码分析](http://www.tianxiaobo.com/2018/06/29/Spring-MVC-原理探秘-一个请求的旅行过程/)
    - 一个请求的旅行过程：`DispatcherServlet#doDispatch(request, response)`
    - 容器的创建过程
-->

#### 4.4 <span id = "4.4">Spring AOP</span>
- [Spring AOP 源码深度解析](https://juejin.cn/post/6844904015843557389)

#### 4.5 <span id = "4.5">Spring MVC</span>
- [Spring MVC 源码深度解析](https://juejin.cn/post/6844904017772937229)
- [拦截器和过滤器的区别](https://www.zhihu.com/question/30212464/answer/1786967139)
<!--
- [Spring AOP 源码分析](http://www.tianxiaobo.com/2018/06/17/Spring-AOP-源码分析系列文章导读/)
  - AOP 系列文章导读：`AbstractAutoProxyCreator#postProcessAfterInitialization()`
  - 筛选合适的通知器
  - 创建代理对象
  - 拦截器链的执行过程

#### 4.6 <span id = "4.6">MyBatis</span>
- [没有实现类，MyBatis 为什么可以进行数据的增删改查](https://bugstack.cn/itstack-demo-any/2019/12/25/源码分析-Mybatis接口没有实现类为什么可以执行增删改查.html)
- [MyBatis 源码分析](http://www.tianxiaobo.com/2018/07/16/MyBatis-源码分析系列文章导读/)
  - MyBatis 源码分析系列文章导读
  - MyBatis 源码分析 - 配置文件解析过程
  - MyBatis 源码分析 - 映射文件解析过程
  - MyBatis 源码分析 - SQL 的执行过程
  - MyBatis 源码分析 - 内置数据源
  - MyBatis 源码分析 - 缓存原理
  - MyBatis 源码分析 - 插件机制
- [MyBatis 中的设计模式总结](http://www.crazyant.net/2022.html)
- [MyBatis 一级缓存和二级缓存](https://zhuanlan.zhihu.com/p/80305146)
-->

<br/>

----------- 第四章 完 ----------

<br/>

### 5. MySQL
1. [MySQL 介绍](#5.1)
2. [存储引擎：InnoDB 和 MyISAM](#5.2)
3. [索引](#5.3)
4. [事务](#5.4)
5. [MVCC](#5.5)

#### 5.1 <span id = "5.1">MySQL 介绍</span>
- [MySQL 十连问](https://mp.weixin.qq.com/s/O_NHjv_YVUi4lSqXnhx5Mg)
- [MySQL 45 讲](https://time.geekbang.org/column/article/67888)
    - 快照读原理：事务到底是隔离的还是不隔离的
    - 当前读原理：幻读是什么，幻读有什么问题
    - 加锁原则：为什么我只改一行的语句，锁这么多
    - 普通索引和唯一索引，应该怎样选择（change buffer 和 redo log）
    
<!--
- [Mysql 专栏](https://juejin.cn/column/6969728433911758862)
- [MySQL 45 讲](https://funnylog.gitee.io/mysql45/)
-->

#### 5.2 <span id = "5.2">存储引擎：InnoDB 和 MyISAM</span>
- [InnoDB 和 MyISAM 区别总结](https://blog.csdn.net/qq_35642036/article/details/82820178)
- [MySQL 中 in 与 Exists 的区别](https://blog.csdn.net/jinjiniao1/article/details/92666614)

#### 5.3 <span id = "5.3">索引</span>
- [聚簇索引，二级索引](https://dev.mysql.com/doc/refman/5.7/en/innodb-index-types.html)
- [组合索引，官方文档](https://dev.mysql.com/doc/refman/5.7/en/multiple-column-indexes.html)
- [MySQL 索引原理详解](https://mp.weixin.qq.com/s/wiqfcVrsLgLvLbsTU-qSag)
- [如何正确的使用索引？](https://mp.weixin.qq.com/s/Ruz3kFg00R9f935x_yuskQ)
  - 最佳左前缀原则失效的情况分析
  - [or 索引失效](https://blog.csdn.net/chenpengjia006/article/details/101228943)
- [Mysql 中 explain 关键字](https://blog.csdn.net/u011391839/article/details/108233098)
    - [Using where; using index 和 using index condition](https://www.zhihu.com/question/444890024)
    - [explain 解读](https://blog.csdn.net/weixin_39805087/article/details/110648927)
- 1000万条数据分页查询，查询 10,000,000 至 10,000,100 条数据，采用**子查询方式**
    - `select * from user_operation_log where id >= (select id from user_operation_log limit 10000000, 1) limit 10`;
    - [一千万数据，怎么快速查询](https://cloud.tencent.com/developer/article/1943956)

#### 5.4 <span id = "5.4">事务</span>
- [官方文档 InnoDB Locking: 各种类型的锁](https://dev.mysql.com/doc/refman/5.7/en/innodb-locking.html)
- [通过各种简单案例，让你彻底搞懂 MySQL 中的锁](https://tonydong.blog.csdn.net/article/details/103324323)
- [MySQL 中的事务和锁：ReadView 图例](https://juejin.cn/post/6855129007336521741)
- [InnoDB 到底怎么加锁的](https://juejin.cn/post/7028435335382040589)
- [MySQL Innodb 引擎什么时候表锁，什么时候行锁？](https://blog.csdn.net/Frankltf/article/details/82976493)
  - [Innodb 解决幻读方案 -- LBCC & MVCC](https://zhuanlan.zhihu.com/p/364331468)
- [MySQL 中的 Redo log 和 Binlog](https://mp.weixin.qq.com/s/XTpoYW--6PTqotcC8tpF2A)
- [MySQL 中的二阶段提交](https://blog.csdn.net/weixin_39663729/article/details/110869452)
  - [两阶段提交](https://juejin.cn/post/7080366887695024141)
- [for update 没有命中索引会锁表么？](https://blog.csdn.net/hardplay123/article/details/88774240)

#### 5.5 <span id = "5.5">MVCC</span>
- [图解 MVCC 多版本并发控制](https://www.jianshu.com/p/b7f5f18cac94)
- [MySQL 各种锁机制的学习](https://www.jianshu.com/p/615f3c7fbe6f)

<br/>

----------- 第五章 完 ----------

<br/>

### 6. Redis
1. [Redis 介绍](#6.1)
2. [Redis 数据结构](#6.2)
3. [Redis 集群](#6.3)
4. [Redis 分布式锁](#6.4)
5. [Redis 缓存常见问题](#6.5)
6. [分布式 ID 生成策略](#6.6)

#### 6.1 <span id = "6.1">Redis 介绍</span>
- 满足CAP中的CP
- [CAP 的解释](https://www.zhihu.com/question/64778723)
- [Redis 思维导图](https://www.processon.com/view/link/6084234d7d9c08118405ab50#map)

#### 6.2 <span id = "6.2">Redis 数据结构</span>
- [Redis 底层数据结构](https://mp.weixin.qq.com/s/z4VjDaDDbspFz1rIBwazIA)
- [Redis 为什么用跳表](https://mp.weixin.qq.com/s/rXIVIW7RM56xwMaQtKnmqA)
- [Redis 3 种特殊类型详解](https://java.isture.com/db/redis/db-redis-data-type-special.html)
- [Redis 应用场景](https://java.isture.com/db/redis/db-redis-introduce.html#_3-redis的使用场景)
- [如何使用 Redis 实现页面 UV 统计](https://juejin.cn/post/6844903785744056333)

#### 6.3 <span id = "6.3">Redis 集群</span>
- 集群的种类：
  - Redis Sentinal 着眼于高可用，在 master 宕机时会自动将 slave 提升为master，继续提供服务。
  - Redis Cluster 着眼于扩展性，在单个 redis 内存不足时，使用 Cluster 进行分片存储。
- [Redis 日志：RDB 和 AOF](https://mp.weixin.qq.com/s/vpuMsen_s5Ye3Giz-59C3w)
- [Redis 主从架构数据同步原理](https://mp.weixin.qq.com/s/j81A849iCe7B4FgT-TVeOA)
- [图解 Redis Cluster 集群原理](https://www.cnblogs.com/detectiveHLH/p/14154665.html)
  - [Cluster 集群能支撑的数据有多大](https://mp.weixin.qq.com/s/qOF9hT_gDvkMH6HbaIvBwg)
  - [搭建集群需要的服务器个数: 三主三从](https://blog.csdn.net/m0_37688634/article/details/79799892)

#### 6.4 <span id = "6.4">Redis 分布式锁</span>
- [分布式锁用 Redis 还是 Zookeeper？](https://zhuanlan.zhihu.com/p/73807097)
  - [Redis 分布式锁方案演进](https://mp.weixin.qq.com/s/l9lcFqfXVI30qJi1r2A5-A)
  - `setnx` 占锁成功，业务代码出现异常或者服务器宕机，没有执行删除锁的逻辑，会造成死锁；
  - `set <key> <value> PX <多少毫秒> NX`: 获取锁时，也需要设置锁的过期时间，这是一个原子操作；
  - 释放锁需要使用 lua 脚本，保证获取锁，比较锁的值，并删除锁的原子性。
  - 阻塞获取锁，即获取不到锁的时候，等待一段时间：`tryLock(long timeout, TimeUnit unit)`。

#### 6.5 <span id = "6.5">Redis 缓存常见问题</span>
- [缓存雪崩，击穿，穿透](https://mp.weixin.qq.com/s/_StOUX9Nu-Bo8UpX7ThZmg)
  - [布隆过滤器](https://www.cnblogs.com/lonely-wolf/p/14451302.html)
- [内存耗尽后，Redis会发生什么（LRU，LFU算法）](https://www.cnblogs.com/lonely-wolf/p/14403264.html)
- [数据库缓存一致性](https://mp.weixin.qq.com/s/U87wrGsx0Eop3CbF9mlTwQ)
- [如何保持 mysql 和 redis 中数据的一致性](https://www.zhihu.com/question/319817091)

#### 6.6 <span id = "6.6">分布式ID生成策略</span>
- [分布式全局唯一ID生成策略](https://yasinshaw.com/articles/67)
- [九种分布式ID生成方式](https://zhuanlan.zhihu.com/p/152179727)
- [雪花算法](https://developer.aliyun.com/article/772913)

<!--
#### 6.2 <span id = "6.2">单机缓存</span>
- [缓存进化史](https://juejin.cn/post/6844903660653117447)
- [Caffeine 缓存原理](https://blog.csdn.net/weixin_34026484/article/details/87942545)
- [如何优雅的设计和使用缓存？](https://juejin.cn/post/6844903665845665805)
- 选读：[Guava Cache 原理](https://crossoverjie.top/2018/06/13/guava/guava-cache/)

- [Seata 分布式事务](https://blog.csdn.net/qq_35067322/article/details/110914143)

- [Sentinel 哨兵集群搭建](https://mp.weixin.qq.com/s/LZxKifLRFnqLiAeSSv7q9A)
- [Redis Sentinel 哨兵集群原理](https://mp.weixin.qq.com/s/rtgh5c6p5zhcfgGeqX5mZA)
    - [Redis 集群脑裂及解决方案](https://blog.csdn.net/LO_YUN/article/details/97131426)
- [基于 Redis 的分布式锁到底安全吗？](https://mp.weixin.qq.com/s/4CUe7OpM6y1kQRK8TOC_qQ)
- [基于 Redis 实现延时队列](https://my.oschina.net/7001/blog/1600633)
- [Zookeeper 的功能和原理](https://zhuanlan.zhihu.com/p/78106824)
-->

<br/>

----------- 第六章 完 ----------

### 7. 分布式相关
1. [Dubbo](#7.1)
2. [Kafka](#7.2)

#### 7.1 Dubbo
- [RPC 调用和 HTTP 调用的区别](https://mp.weixin.qq.com/s/mqKulTHTYNx_ks8-LVvJ5A)
  - [既然有 HTTP 请求，为什么还要用 RPC 调用](https://www.zhihu.com/question/41609070)
- [Dubbo 超时重试和异常处理](https://www.cnblogs.com/xuwc/p/8974709.html)
- [Dubbo 和 SpringCloud 比较](https://zhuanlan.zhihu.com/p/135412402)

#### 7.2 Kafka
- [为什么使用消息队列](https://zhuanlan.zhihu.com/p/372485966)
- [Kafka 实践指南](https://juejin.cn/post/6999504790715629576)
- [Kafka 为什么快](https://riemann.blog.csdn.net/article/details/119515188)
- [Kafka 常见问题](https://zhuanlan.zhihu.com/p/344277683)
    - [Kafka 如何保证高可用](https://zhuanlan.zhihu.com/p/363082581)
    - [Kafka 可用性二](https://zhuanlan.zhihu.com/p/521775752)
- [MQ 常见问题](https://mp.weixin.qq.com/s/j5Jedf7OSPkyNs11610v8Q)
- [Kafka 踩过的坑](https://mp.weixin.qq.com/s/YPkE3Tsu3RVbhfVZCBt1pQ)
- [Kafka 消息丢失](https://juejin.cn/post/7135101805179961352)
- [kafka 如何保证不重复消费又不丢失数据](https://www.zhihu.com/question/483747691/answer/2392949203)
- [接口幂等性](https://mp.weixin.qq.com/s/7P2KbWjjX5YPZCInoox-xQ)

### 7.3 秒杀系统设计
- [秒杀商品](https://mp.weixin.qq.com/s/l05_28xe6O4vZUQEmnu2Ug)
- [设计一个电商平台积分兑换系统](https://zhuanlan.zhihu.com/p/92848230)
- [redis 延时队列（订单超时未支付）](https://developer.aliyun.com/article/784457)
- [Kafka 延迟队列](https://zhuanlan.zhihu.com/p/365802989)

<br/>

----------- 第七章 完 ----------

<br/>

### 8. 设计模式
- [单例模式](https://www.infoq.cn/article/double-checked-locking-with-delay-initialization)
- [策略模式](https://my.oschina.net/u/4662964/blog/4723828)
    - [策略模式 2](https://bugstack.cn/md/develop/design-pattern/2020-07-05-重学%20Java%20设计模式《实战策略模式》.html)
- [管道模式(责任链模式)](https://my.oschina.net/u/4662964/blog/4759287)
  - [责任链模式（一）](https://zhuanlan.zhihu.com/p/109228171)
  - [责任链模式（二）](https://zhuanlan.zhihu.com/p/24737592)
- [责任链模式与策略模式区分](https://zhuanlan.zhihu.com/p/113398276)
- [模板模式](https://mp.weixin.qq.com/s/QBmDiyfST13nQJUcPLLXOg)
- [状态模式](https://bugstack.cn/md/develop/design-pattern/2020-07-02-重学%20Java%20设计模式《实战状态模式》.html)
- [适配器模式](https://zhuanlan.zhihu.com/p/44064957)

#### 8.1 设计模式的其他参考资料
- [设计模式之美](https://time.geekbang.org/column/intro/100039001)
    - 单例模式，工厂模式，代理模式，装饰器模式，适配器模式，观察者模式，模板模式，策略模式，职责链模式，状态模式
<!--
- [设计模式也可以这么简单](https://javadoop.com/post/design-pattern)
设计模式之美：https://github.com/jianglinyang8/beauty-of-design-pattern

-->
<br/>

----------- 第八章 完 ----------

### 9. 算法

#### 9.1 算法可视化平台
- [Algorithm-visualizer](https://github.com/algorithm-visualizer/algorithm-visualizer)
- [Visualgo](https://visualgo.net/en)
- [Data Structure Visualizations](https://www.cs.usfca.edu/~galles/visualization/Algorithms.html)

#### 9.2 大厂常考题目
- [codetop](https://codetop.cc/#/home)

#### 9.3 自己面试中碰到的题目
- [232. Implements Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)
- [912. 快速排序(QuickSort)](https://leetcode.com/problems/sort-an-array/)
- [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
  - [在 100G 文件中找出出现次数最多的 100 个IP](https://blog.csdn.net/fycy2010/article/details/46945641)
- 多线程交替打印：
  - [三个线程，一个线程负责打印1，4，7，……；第二个负责打印2，5，8，……，第三个负责打印3，6，9](https://zhuanlan.zhihu.com/p/110001146)
  - [A B C A B C A B C 打印](https://stackoverflow.com/questions/43176198/multithreading-in-java-to-print-abc-using-3-threads/51240847)
  - [AAA BBB CCC打印](https://github.com/Noodlescn/netty/blob/master/src/main/java/com/noodles/thread/printnum/DemoTask4.java)
  - [手动实现一个 LRU Cache](https://www.cnblogs.com/crossoverJie/p/9352353.html)


<br/>
<br/>
----------- 鸣谢 ----------

- [Java 基础面试题总结](https://mp.weixin.qq.com/s/pTQ2hGYZwTDZocvwSCQHRg)
- [各公司面经参考](https://www.nowcoder.com/discuss/432605)
- [小傅哥的 butstack 虫洞栈](https://bugstack.cn/)
- [WangMeng](https://www.cnblogs.com/wang-meng/)
- [noteless](https://www.cnblogs.com/noteless/p/9400742.html)
- [编了个程](https://yasinshaw.com/)
- [田小波](http://www.tianxiaobo.com/)
- [Javadoop](https://javadoop.com/)
- [小林coding](https://mp.weixin.qq.com/s/_StOUX9Nu-Bo8UpX7ThZmg)
- [码哥字节](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzU3NDkwMjAyOQ==&action=getalbum&album_id=1708320618028318723&scene=173&from_msgid=2247485665&from_itemidx=1&count=3&nolastread=1#wechat_redirect)
- [路人甲Java](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzA5MTkxMDQ4MQ==&action=getalbum&album_id=1322186253722501121&scene=173&from_msgid=2648933422&from_itemidx=1&count=3&nolastread=1#wechat_redirect)
- [美团技术团队](https://tech.meituan.com/tags/java.html)
- [AbeJeffrey](https://my.oschina.net/7001)

<!--


<br/>

### 8. 网络编程

#### 8.1 多路复用
- [一举拿下 I/O 多路复用](https://mp.weixin.qq.com/s/Qpa0qXxuIM8jrBqDaXmVNA)
- [Linux IO模式以及 select，poll，epoll 详解](https://zhuanlan.zhihu.com/p/148972109)
- [一文读懂 Redis 中的多路复用模型](https://mp.weixin.qq.com/s/sSM16v_cUpRznf80myQozA)

#### 8.2 TCP
- [TCP 三次握手和四次挥手](https://mp.weixin.qq.com/s/tH8RFmjrveOmgLvk9hmrkw)

<br/>

----------- 第八章 完 ----------

<br/>

- [SpringCloud Alibaba](https://www.bilibili.com/video/BV18E411x7eT)

- [Dubbo 介绍](https://www.bilibili.com/video/BV1VE411q7dX)

### 9. Netty
- Netty 是一个异步的，基于事件驱动的网络应用框架。
- [Netty 入门视频](https://www.bilibili.com/video/BV1DJ411m7NR)
- [Java NIO：Buffer，Channel 和 Selector](https://javadoop.com/post/java-nio)
- [Netty 原理架构解析](https://juejin.cn/post/6844903704668160008)
- [Netty 源码解析系列](https://javadoop.com/post/netty-part-1)
  - Netty 的 Channel
  - Netty 的 Future 和 Promise
  - Netty 的 ChannelPipeline
  - Netty 的线程池分析
  - Netty 的 register 操作
  - NioEventLoop 工作流程
  - 回到 Channel 的 register 操作
  - connect 和 bind 过程分析

<br/>

----------- 第九章 完 ----------


quartz 源码解析: 
        - Spring中@Scheduled的实现原理: https://www.cnblogs.com/throwable/p/12616945.html
        - https://bugstack.cn/itstack-demo-any/2020/01/01/源码解析-Spring定时任务Quartz执行全过程源码解读.html
        - 任务调度：时间轮算法经典案例解析及应用实现: https://mp.weixin.qq.com/s/CcChX0MvxkdlToaVQT1BOA



4.3.1 Dubbo
    通信模型是什么样的
    Dubbo 和 Spring Cloud 有什么区别
    dubbo都支持什么协议，推荐用哪种 dubbo://（推荐） rmi:// hessian:// http:// webservice:// thrift:// memcached:// redis:// rest://
    Dubbo里面有哪几种节点角色
    Dubbo中怎么处理的超时断开

    源码解析: http://www.tianxiaobo.com/2018/10/01/Dubbo-源码分析-SPI-机制/
        - SPI 机制
        - 自适应拓展原理
        - 服务导出
        - 服务引用
        - 集群容错之Directory
        - 集群容错之Router
        - 集群容错之Cluster
        - 集群容错之LoadBalance
    

Java 面试： https://www.bilibili.com/video/BV1zb411M7NQ

网络相关：
    https://pan.baidu.com/s/1FfR8jpxdk6Bro23KddyU8A  密码: 9c4f



算法：
    快排
    二叉树
    B 树
    B+ 树
    递归
    动态规划
    skipList
    
    树:
      B+ 树： http://offer.liangsonghua.me/docs/basic/algo/tree/
      堆的应用之ScheduledThreadPoolExecutor 中的 DelayedWorkQueue： https://mp.weixin.qq.com/s/CcChX0MvxkdlToaVQT1BOA
    
    Hash: http://offer.liangsonghua.me/docs/basic/algo/hash/

    KMP 算法: http://offer.liangsonghua.me/docs/basic/algo/kmp/

    跳跃表: http://offer.liangsonghua.me/docs/basic/algo/skip_list/

    - 剑指offer：
      - http://offer.liangsonghua.me/docs/offer/

    刷题模板：
        - https://github.com/greyireland/algorithm-pattern

    二叉查找树: https://www.cnblogs.com/skywang12345/p/3576328.html


    红黑树: 
        - https://blog.csdn.net/v_july_v/article/details/6105630
        - https://segmentfault.com/a/1190000012728513
        - www.tianxiaobo.com/2018/01/11/红黑树详细分析/
        - https://aobing.blog.csdn.net/article/details/109503539

    算法刷题: https://juejin.cn/post/6844904012987236359
    https://www.javachat.cc/2021/01/25/八、面试/算法/面试时到底该刷哪些算法题？没关系，这里整理了高频的三百道/
    www.geekxh.com/0.0.学习须知/01.html

    14种模板： https://mp.weixin.qq.com/s/f74-nquNDpMjGUStu64Pig

    https://github.com/doocs/leetcode

    刷啥题？如何刷？如何面？
        - https://www.1point3acres.com/bbs/thread-746561-1-1.html



WebSocket: https://blog.csdn.net/itguangit/article/details/103053642



4.5.2 数据库设计
    分库分表(水平拆分、垂直拆分)
    业务场景
    基础配置优化相关
4.5.3 服务治理
    负载均衡
    熔断
    降级
    限流
    黑白名单
4.5.5 监控
    系统非入侵全链路监控
    TP99、TP999、QPS、TPS的熟悉程度
        https://mp.weixin.qq.com/s/LFBK_3Mfo644mzXZXxsSTw

4.5.6 压测
    JVM参数
    GC调优
    代码优化

<br/>
<br/>


**扩展阅读:**

多线程编程：
    https://blog.csdn.net/weixin_36586120/article/details/108934432

深入理解java内存模型: https://www.infoq.cn/minibook/java_memory_model
Java 的对象模型: https://blog.csdn.net/uftjtt/article/details/80200553
高并发与多线程: https://blog.csdn.net/uftjtt/category_7640713.html
java 锁底层原理: https://juejin.cn/post/6872989550868856840
Java 锁的那些事儿: https://www.infoq.cn/article/DOvfyp8kFP5YPdaTAJFF?utm_source=related_read_bottom&utm_medium=article
深入浅出 Java Concurrency: http://www.blogjava.net/xylz/archive/2010/07/08/325587.html
死磕 java 并发: https://chenssy.blog.csdn.net/article/details/81154894
Spring 框架的设计理念与设计模式分析: https://blog.csdn.net/uftjtt/article/details/80481912
Spring 容器的基本实现: https://blog.csdn.net/uftjtt/article/details/79896110
https://beginnersbook.com/
https://github.com/coderbruis/JavaSourceCodeLearning
https://github.com/coderbruis/Java-T-Shaped
https://www.cnblogs.com/itdragon/p/8506278.html
https://snailclimb.gitee.io/javaguide-interview/#/
quartz 源码解析: https://www.jianshu.com/p/3f77224ad9d4
java 并发编程的艺术: http://itmyhome.com/java-concurrent-programming/java-concurrent-programming.pdf
高级岗面试: https://xie.infoq.cn/article/7116114c1ac8dc598346d8518
JavaTutorials: https://www.javamex.com/
面试: https://snailclimb.gitee.io/javaguide/#/?id=mysql
https://blog.csdn.net/thewindkee/article/details/102723838  四种引用
Kafka：https://www.bilibili.com/video/BV1a4411B7V9
        - kafka 常见问题：https://mp.weixin.qq.com/s/GxznwzqOqgrhQw_-GNwnBQ
RocketMQ: https://www.bilibili.com/video/BV1RE411r75d
知乎数据结构：
        - https://www.zhihu.com/topic/19625716/hot
Redis 数据结构： https://mp.weixin.qq.com/s/qFDOFr4HYpgUg-J_VCNvQw

Redis dict：https://mp.weixin.qq.com/s/qFDOFr4HYpgUg-J_VCNvQw
redis sds: https://zhuanlan.zhihu.com/p/21535555
redis robj: https://zhuanlan.zhihu.com/p/21851177
redis ziplist: https://zhuanlan.zhihu.com/p/21854009
redis quicklist: https://zhuanlan.zhihu.com/p/21854144
redis intset: https://mp.weixin.qq.com/s/Z6OZpDg1yQD5MaRmcLHcLw

布谷鸟过滤器: https://zhuanlan.zhihu.com/p/68418134

分布式事务：
    - https://jadyer.cn/2020/08/06/seata-intro/
    - Seata 原理: https://mp.weixin.qq.com/s/hiiVNElHucAr5SnAWG4BIw
    - seata 是什么： https://zhuanlan.zhihu.com/p/343269551
脑裂问题：https://mp.weixin.qq.com/s/Jg01zDCNVR5bw0WDbyMxWQ
ConcurrentSkipListMap: https://blog.csdn.net/coslay/article/details/44819823
synchronized锁和Lock锁: https://www.zhihu.com/question/332327455
StampedLock 源码分析: https://www.cnblogs.com/tong-yuan/p/StampedLock.html
基于 Redis 实现的分布式限流： https://pandaychen.github.io/2020/09/21/A-DISTRIBUTE-GOREDIS-RATELIMITER-ANALYSIS/
Sentinel： https://javadoop.com/post/sentinel
RateLimiter：https://www.javadoop.com/post/rate-limiter
StampedLock 源码解读: https://cloud.tencent.com/developer/article/1628994
高性能队列 Disruptor: 
    - https://tech.meituan.com/2016/11/18/disruptor.html
    - disruptor 感想： https://blog.csdn.net/Bruceleexiaokan/article/details/8291915
CompletableFuture 使用介绍: 
    - https://javadoop.com/post/completable-future
    - https://yasinshaw.com/articles/29
JVM 安全点: https://zhuanlan.zhihu.com/p/286110609
- https://www.hollischuang.com/archives/2322 深入分析Java的编译原理
- https://www.hollischuang.com/archives/2398 对象和数组并不是都在堆上分配内存
- 深入理解Java中的逃逸分析: https://www.hollischuang.com/archives/2583
- https://segmentfault.com/a/1190000038262877 JVM 逃逸分析
- https://www.cnblogs.com/cnndevelop/p/12164283.html JIT 即时编译及优化技术
Spring IOC：https://blog.csdn.net/uftjtt/article/details/80647848
卷王手册 https://cloud.189.cn/t/yIbuMnUFjmYz（访问码：c8hx）
JavaGuide面试突击版 https://pan.baidu.com/s/1ZxLpxFe_7AuUNUUeAUnF0w  密码: g2rc
高性能无锁队列disruptor: https://juejin.cn/post/6844903648875528206
- Quartz 基本介绍:_ https://www.jianshu.com/p/3f77224ad9d4_
          - Scheduler 初始化: https://www.jianshu.com/p/760a96048e3c
          - JobDetail, Trigger 和 它们的 Builder: https://www.jianshu.com/p/a6015e9760af
          - QuartzScheduler 和 Listener 事件监听: https://www.jianshu.com/p/a6015e9760af
          - QuartzSchedulerThread: https://www.jianshu.com/p/38e5e0953e56
          - 解析 Cron 表达式: https://www.jianshu.com/p/fb92bdf7a093
 - SpringBoot 启动过程经历了什么： https://blog.csdn.net/yunfeng482/article/details/92819585
 SpringBoot 的 jar 可以直接运行: https://mp.weixin.qq.com/s/bFmqPuircVxcSz4f5eUGkw
 https://www.zhihu.com/column/c_1119180338215292928

 TCP 重传,滑动窗口,流量控制: https://mp.weixin.qq.com/s/Tc09ovdNacOtnMOMeRc_uA
TCP 半连接队列和全连接队列满了会发生什么: https://mp.weixin.qq.com/s/2qN0ulyBtO2I67NB_RnJbg
RDB和AOF 持久化: https://www.cnblogs.com/wdliu/p/9377278.html
大量数据去重 Bitmap 和 布隆过滤器: https://blog.csdn.net/zdxiq000/article/details/57626464
布隆过滤器: https://zhuanlan.zhihu.com/p/43263751
布隆过滤器算法原理： https://mp.weixin.qq.com/s/dC8d9sseIk2gi-8mPrMydw
浅谈大数据中的2PC, 3PC, Paxos, Raft 和 ZAB: https://mp.weixin.qq.com/s/b5mGEbn-FLb9vhOh1OpwIg
- zookeeper 分布式锁原理：https://mp.weixin.qq.com/s/jn4LkPKlWJhfUwIKkp3KpQ
- Zookeeper 羊群效应： https://blog.csdn.net/lbh199466/article/details/104602694
ZooKeeper的十二连问：https://mp.weixin.qq.com/s/XR2C-ronEHMeLtlK3T6tGw
- 基于 Zookeeper 的分布式锁实现:http://www.tianxiaobo.com/2018/01/20/基于-Zookeeper-的分布式锁实现/
- Curator 分布式锁示例：https://blog.csdn.net/hd20086996/article/details/105408025
- Sql 中 where 条件在数据库中提取与应用: https://mp.weixin.qq.com/s/6oVWF-k4NbdEdKaMtVOhhQ
- dubbo 的 handler 机制: https://blog.csdn.net/wjlucky262/article/details/105907587