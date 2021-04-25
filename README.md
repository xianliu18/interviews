### 1. 概述

本项目是以[小傅哥的博客](https://bugstack.cn/itstack/interview.html)为蓝本整理出来的，自认为是面向伪高级程序员一份参考资料。

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

- [Java 基础面试题总结](https://mp.weixin.qq.com/s/pTQ2hGYZwTDZocvwSCQHRg)
- [各公司面经参考](https://www.nowcoder.com/discuss/432605)


优秀博客推荐：
- [小傅哥的 butstack 虫洞栈](https://bugstack.cn/)
- [WangMeng](https://www.cnblogs.com/wang-meng/)
- [noteless](https://www.cnblogs.com/noteless/p/9400742.html)
- [编了个程](https://yasinshaw.com/)
- [田小波](http://www.tianxiaobo.com/)
- [码哥字节](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzU3NDkwMjAyOQ==&action=getalbum&album_id=1708320618028318723&scene=173&from_msgid=2247485665&from_itemidx=1&count=3&nolastread=1#wechat_redirect)
- [路人甲Java](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzA5MTkxMDQ4MQ==&action=getalbum&album_id=1322186253722501121&scene=173&from_msgid=2648933422&from_itemidx=1&count=3&nolastread=1#wechat_redirect)
- [美团技术团队](https://tech.meituan.com/tags/java.html)

<br/>

----------- 概述 完 ----------

<br/>

### 1. JVM 相关内容
1. [JDK，JRE，JVM 关系](#1.1)
2. [JVM 内存模型](#1.2)
3. [JVM 类加载机制](#1.3)
4. [垃圾收集算法及对应实现](#1.4)
5. [JVM 故障处理](#1.5)
6. [Java 8 新特性总结](#1.6)

<br/>

#### 1.1 <span id="1.1">JDK，JRE，JVM关系</span>
- [JDK-JRE-JVM 是什么关系](https://bugstack.cn/interview/2020/12/23/面经手册-第23篇-JDK-JRE-JVM-是什么关系.html)

#### 1.2 <span id="1.2">JVM 内存模型</span>
- [图解 JVM 内存布局](https://segmentfault.com/a/1190000021424972)
- [Java 版虚拟机](https://bugstack.cn/interview/2021/01/06/面经手册-第25篇-JVM内存模型总结-有各版本JDK对比-有元空间OOM监控案例-有Java版虚拟机-综合学习更容易.html)

#### 1.3 <span id="1.3">JVM 类加载机制</span>
- [new 一个对象，背后发生了什么](https://zhuanlan.zhihu.com/p/257863129)
- [JVM 加载机制：双亲委派模型](https://segmentfault.com/a/1190000021448897)
- [被破坏的双亲委派模型之服务商供应接口Java SPI](https://www.jianshu.com/p/e6f1f89a9e22)
- [Java 即时编译器原理解析及实践（逃逸分析）](https://tech.meituan.com/2020/10/22/java-jit-practice-in-meituan.html)

#### 1.4 <span id="1.4">垃圾收集算法及对应实现（垃圾收集器）</span>
- [一次性把Java的四种引用说清楚](https://blog.csdn.net/yasinshaw/article/details/106205353)
- [如何判断对象已死](https://bugstack.cn/interview/2021/01/20/面经手册-第27篇-JVM-判断对象已死-实践验证GC回收.html)
- [经典垃圾收集器](https://zhuanlan.zhihu.com/p/259740590)
- [JVM 垃圾回收](https://segmentfault.com/a/1190000021516052)
- [理解JVM安全点](https://zhuanlan.zhihu.com/p/286110609)
- [JVM 安全点引起的问题](https://mp.weixin.qq.com/s/KDUccdLALWdjNBrFjVR74Q)

#### 1.5 <span id="1.5">JVM 故障处理</span>
- [JVM 故障处理工具使用总结](https://bugstack.cn/interview/2021/01/13/面经手册-第26篇-JVM故障处理工具-使用总结.html)
- [Minor GC，Full GC，Major GC介绍](https://www.cnblogs.com/cnndevelop/p/12142638.html)
- [频繁 Full GC 问题原因分析](https://blog.csdn.net/weixin_42228338/article/details/98685104)
- [线上 OOM 问题排查](https://blog.csdn.net/qq_16681169/article/details/53296137)
    - `top` 命令, 查看机器CPU以及内存是否正常
    - `jstat -gc pid 1000 100` 监控JVM内存运行状况和gc频率
    - `jmap -histo:live pid` 可用统计存活对象的分布情况，找到最耗内存的对象。
    - `jmap -dump:live,format=b,file=dump3.hprof pid` 使用 jmap dump 内存快照。
    - 使用`MAT`工具进行分析
- [聊聊 JStack 工作原理](https://www.cnblogs.com/qingquanzi/p/8974850.html)

#### 1.6 <span id="1.6">Java 8 新特性总结</span>
- [JDK 1.8 新特性实战篇](http://bugstack.cn/itstack-demo-any/2019/12/10/有点干货-Jdk1.8新特性实战篇(41个案例).html)

<br/>

----------- 第一章 完 ----------

<br/>

### 2. Java 集合相关
1. [String](#2.1)
2. [ArrayList 和 LinkedList](#2.2)
3. [HashMap](#2.3)

#### 2.1 <span id="2.1">String 相关</span>
- [String，StringBuilder，StringBuffer 分析](https://bugstack.cn/interview/2020/09/17/面经手册-第11篇-StringBuilder-比-String-快-空嘴白牙的-证据呢.html)

#### 2.2 <span id="2.2">ArrayList 和 LinkedList</span>
- [ArrayList 源码分析](https://bugstack.cn/interview/2020/08/27/面经手册-第7篇-ArrayList也这么多知识-一个指定位置插入就把谢飞机面晕了.html)
- [ArrayList 和 LinkedList 性能比较](https://bugstack.cn/interview/2020/08/30/面经手册-第8篇-LinkedList插入速度比ArrayList快-你确定吗.html)
- [CopyOnWriteArrayList 详解](https://segmentfault.com/a/1190000019787913)
- [CopyOnWriteArrayList 利弊总结](https://stefan.blog.csdn.net/article/details/111601912)

#### 2.3 <span id="2.3">HashMap</span>
- [HashMap 扰动函数，负载因子，链表扩容](https://bugstack.cn/interview/2020/08/07/面经手册-第3篇-HashMap核心知识-扰动函数-负载因子-扩容链表拆分-深度学习.html)
- [HashMap 数据插入，查找，删除，遍历](https://bugstack.cn/interview/2020/08/13/面经手册-第4篇-HashMap数据插入-查找-删除-遍历-源码分析.html)
- [HashMap 1.7 与 1.8 区别](https://blog.csdn.net/carson_ho/article/details/79373026)
- [ConcurrentHashMap 源码解析](https://blog.csdn.net/weixin_36586120/article/details/114808650)
- [Java 7/8 中的 HashMap 和 ConcurrentHashMap 全解析](https://javadoop.com/post/hashmap)

<br/>

----------- 第二章 完 ----------

<br/>

### 3. 并发编程
1. [Thread 介绍](#3.1)
2. [多线程协作 wait，notify，notifyAll](#3.2)
3. [ThreadLocal 介绍](#3.3)
4. [并发编程基础](#3.4)
5. [volatile 关键字](#3.5)
6. [synchronized 关键字](#3.6)
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

#### 3.2 <span id="3.2">多线程协作 wait，notify，nofityAll</span>
- [多线程协作 wait，nofity，notifyAll 方法简介](https://www.cnblogs.com/noteless/p/10468834.html)
- [三种让线程等待和唤醒的方法](https://mp.weixin.qq.com/s/I81Ldqr9COA6MyOlRsJARg)
- [sleep，yield 以及 join 方法](https://www.cnblogs.com/noteless/p/10443446.html)

#### 3.3 <span id="3.3">ThreadLocal 介绍</span>
- [ThreadLocal 源码分析](https://bugstack.cn/interview/2020/09/23/面经手册-第12篇-面试官-ThreadLocal-你要这么问-我就挂了.html)
- [图文深度解析 ThreadLocal](https://www.cnblogs.com/wang-meng/p/12856648.html)
- [ThreadLocal 为什么会内存泄漏](https://blog.csdn.net/thewindkee/article/details/89390145)
- [ThreadLocal 在 Quartz 和 MyBatis 中的应用](https://blog.csdn.net/yasinshaw/article/details/106774620)
- [TransmittableThreadLocal 原理分析](https://mp.weixin.qq.com/s/1VVu25bzea1jzAWz7fKEUA)
- [Netty FastThreadLocal 原理分析](https://blog.csdn.net/mycs2012/article/details/90898128)

#### 3.4 <span id="3.4">并发编程基础</span>
- [Java 内存模型JMM，原子性，可见性，有序性简介](https://www.cnblogs.com/noteless/p/10401193.html)
- [重排序与happens-before](http://concurrent.redspider.group/article/02/7.html)

#### 3.5 <span id="3.5">volatile 关键字</span>
- [volatile 实现内存可见性原理](https://bugstack.cn/interview/2020/10/21/面经手册-第14篇-volatile-怎么实现的内存可见-没有-volatile-一定不可见吗.html)
- [图解 volatile 内存屏障](http://concurrent.redspider.group/article/02/8.html)
- [final 关键字与安全发布](https://www.cnblogs.com/noteless/p/10416678.html)

#### 3.6 <span id="3.6">synchronized 关键字</span>
- 基于 JVM 层面的悲观锁
- [synchronized 锁升级过程分析](https://bugstack.cn/interview/2020/10/28/面经手册-第15篇-码农会锁-synchronized-解毒-剖析源码深度分析.html)
- [通过反编译 synchronized 代码，查看其原理](https://www.cnblogs.com/paddix/p/5367116.html)

#### 3.7 <span id="3.7">ReentrantLock</span>
- JDK 层面的悲观锁
- [Lock 接口与 synchronized 关键字对比](https://www.cnblogs.com/noteless/p/10481286.html)
- [Lock 类放在 try 块之内和之外有什么区别？](https://www.zhihu.com/question/54613772)
- [ReentrantLock 可重入锁使用](https://zhuanlan.zhihu.com/p/88884729)
- [ReentrantLock 公平锁讲解](https://bugstack.cn/interview/2020/11/04/面经手册-第16篇-码农会锁-ReentrantLock之公平锁讲解和实现.html)
- [四种自旋锁原理分析(SpinLock，TicketSpinLock，CLH，MCS)](https://stefan.blog.csdn.net/article/details/108750554)

#### 3.8 <span id="3.8">CAS</span>
- [CAS 与原子操作](http://concurrent.redspider.group/article/02/10.html)
- [Java 魔法类： Usafe 应用解析](https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html)
- [比 AtomicLong 更优秀的 LongAddr 原理分析](https://www.cnblogs.com/wang-meng/p/12892695.html)

#### 3.9 <span id="3.9">AQS 讲解(AbstractQueuedSynchronizer)</span>
- [AQS 原理分析和实践使用](https://bugstack.cn/interview/2020/11/11/面经手册-第17篇-码农会锁-ReentrantLock之AQS原理分析和实践使用.html)
- [图解 AQS 原理](https://www.cnblogs.com/wang-meng/p/12816829.html)
- [协作式中断 Java 线程](https://blog.csdn.net/yasinshaw/article/details/107328906)
- [从 ReentrantLock 的实现看 AQS 原理及应用](https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html)
- [AQS 独占-共享模式](http://www.tianxiaobo.com/2018/05/01/AbstractQueuedSynchronizer-原理分析-独占-共享模式/)
- [Condition 实现原理](https://cloud.tencent.com/developer/article/1638926)
- [Condition 实现原理](http://www.tianxiaobo.com/2018/05/04/AbstractQueuedSynchronizer-原理分析-Condition-实现原理/)

#### 3.10 <span id="3.10">Semaphore，CountDownLatch，CyclicBarrier</span>
- [不可不说的 Java “锁”事](https://tech.meituan.com/2018/11/15/java-lock.html)
- [AQS 共享锁，Semaphore，CountDownLatch](https://bugstack.cn/interview/2020/11/18/面经手册-第18篇-AQS-共享锁-Semaphore-CountDownLatch-听说数据库连接池可以用到.html)
- [CountDownLatch 与 CyclicBarrier 原理分析](http://www.tianxiaobo.com/2018/05/10/Java-线程同步组件-CountDownLatch-与-CyclicBarrier-原理分析/)
- Semaphore 应用场景：限流
  - [高并发中常见的限流方式（一）](https://mp.weixin.qq.com/s/37WkBzmGb4Fevbk4HQEISw)
  - [高并发中常见的限流（二）](https://juejin.cn/post/6898897317806800904)

#### 3.11 <span id="3.11">线程池</span>
- [创建线程池的四种方式](https://bugstack.cn/interview/2020/12/16/面经手册-第22篇-线程池的介绍和使用-以及基于jvmti设计非入侵监控.html)
- [ThreadPoolExecutor 线程池实现原理](https://bugstack.cn/interview/2020/12/09/面经手册-第21篇-手写线程池-对照学习ThreadPoolExecutor线程池实现原理.html)
- [图解 ThreadPoolExecutor 线程池原理](https://www.cnblogs.com/wang-meng/p/12945703.html)
- [什么是双端队列-延迟队列-阻塞队列](https://bugstack.cn/interview/2020/09/03/面经手册-第9篇-队列是什么-什么是双端队列-延迟对列-阻塞队列-全是知识盲区.html)
- [Java 线程池实现原理及其在美团业务中的实践](https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html)

<br/>

----------- 第三章 完 ----------

<br/>



<!--



4.3.3 SpringBoot
    SpringBoot 怎么开发一个自己的Stater
        - SpringBoot 自动装配原理: https://zhuanlan.zhihu.com/p/345895748
    
    Java SPI 机制违反双亲委派原则: https://www.jianshu.com/p/e6f1f89a9e22
    Springboot SPI机制: https://blog.csdn.net/pycharm_u/article/details/108196307
    SpringBoot SPI机制: https://www.jianshu.com/p/6756d61b892f
    dubbo，jdk，和 Spring 的 SPI 机制比较: https://juejin.cn/post/6950266942875779108


### 5, 反射、代理
- 怎么实现反射调用方法
- 怎么代理一个类，有什么场景使用
- 类代理的原理是什么
- 有什么框架可以做类代理

https://bugstack.cn/interview/2020/10/14/面经手册-第13篇-除了JDK-CGLIB-还有3种类代理方式-面试又卡住.html

JDK 和 Cglib 动态代理的实现和区别: https://juejin.cn/post/6857769271737614349

4.2.1 Spring
    Bean的注册过程
    Bean的定义都包括什么信息
    Spring 事务中的隔离级别有哪几种
    schedule 使用

    Spring IOC 详解:
        - https://juejin.cn/post/6844904014337802248
        - http://www.tianxiaobo.com/2018/05/30/Spring-IOC-容器源码分析系列文章导读/
            - IOC 导读 AbstractApplicationContext#refresh()
            - 获取单例 Bean  AbstractBeanFactory.getBean("");
            - 创建单例 Bean 的过程  AbstarctAutowireCapableBeanFactory.createBean -- doCreateBean
            - 创建原始 Bean 对象  AbstarctAutowireCapableBeanFactory.createBeanInstance 创建BeanWrapper
            - 循环依赖的解决办法  
            - 填充属性到 Bean 原始对象  AbstractAutowireCapableBeanFactory.populateBean()
            - 余下的初始化工作


    Spring AOP 设计基本原理: Aspect Oriented Programming（AOP）
        https://juejin.cn/post/6844904015843557389
        http://www.tianxiaobo.com/2018/06/17/Spring-AOP-源码分析系列文章导读/
            - AOP 文章导读  AbstractAutoProxyCreator#postProcessAfterInitialization
            - 筛选合适的通知器
            - 创建代理对象
            - 拦截器链的执行过程

    SpringMVC 源码解读: 
        - https://juejin.cn/post/6844904017772937229
        - http://www.tianxiaobo.com/2018/06/29/Spring-MVC-原理探秘-一个请求的旅行过程/
            - 一个请求的旅行过程  DispatcherServlet#doDispatch
            - 容器的创建过程

    超详细Spring IOC, AOP: https://juejin.cn/post/6844904030745919495（Spring Bean的生命周期）


    https://bugstack.cn/itstack-demo-any/2020/01/08/源码分析-像盗墓一样分析Spring是怎么初始化xml并注册bean的.html
    https://bugstack.cn/itstack-demo-any/2020/01/20/源码分析-手写mybait-spring核心功能(干货好文一次学会工厂bean-类代理-bean注册的使用).html
    
    quartz 源码解析: 
        - Spring中@Scheduled的实现原理: https://www.cnblogs.com/throwable/p/12616945.html
        - https://bugstack.cn/itstack-demo-any/2020/01/01/源码解析-Spring定时任务Quartz执行全过程源码解读.html
        - 任务调度：时间轮算法经典案例解析及应用实现: https://mp.weixin.qq.com/s/CcChX0MvxkdlToaVQT1BOA


    深入解密来自未来的缓存-Caffeine： https://blog.csdn.net/weixin_34026484/article/details/87942545
        - 缓存进化史: https://juejin.cn/post/6844903660653117447
        - 如何优雅的设计和使用缓存: https://juejin.cn/post/6844903665845665805

// TODO: 

4.2.2 Mybatis
    mybatis在spring的使用中，只需要定义接口，就可以和xml中的配置的sql语句，进行关联，执行数据库增删改查操作。怎么实现的
    session是怎么管理的

    https://bugstack.cn/itstack-demo-any/2019/12/25/源码分析-Mybatis接口没有实现类为什么可以执行增删改查.html

    源码解读: http://www.tianxiaobo.com/2018/07/16/MyBatis-源码分析系列文章导读/
        - mybatis 文章导读
        - 配置文件解析过程
        - 映射文件解析过程
        - SQL 的执行过程
        - 内置数据源
        - 缓存原理
        - 插件机制

    mybatis 设计模式: https://mp.weixin.qq.com/s/aH7gGmuXe50R9koYUZPM-g


// TODO: 4.16 计划完成



netty 
    - Netty 是一个异步的, 基于事件驱动的网络应用框架, 用以快速开发高性能, 高可靠性的网络IO程序

    入门视频：https://www.bilibili.com/video/BV1DJ411m7NR

    多路复用： 
      - 一举拿下 I/O 多路复用：https://mp.weixin.qq.com/s/Qpa0qXxuIM8jrBqDaXmVNA
      - Linux IO模式及select，poll，epoll：https://zhuanlan.zhihu.com/p/148972109
      - Redis 多路复用： https://mp.weixin.qq.com/s/sSM16v_cUpRznf80myQozA

    Java NIO: Buffer, Channel 和 Selector: https://javadoop.com/post/java-nio

    Netty 架构解析：https://juejin.cn/post/6844903704668160008
    Netty 源码解析系列: https://javadoop.com/post/netty-part-1
  
    TCP 三次握手和四次挥手: https://mp.weixin.qq.com/s/tH8RFmjrveOmgLvk9hmrkw


Redis：(CP)
命令
    计数命令
    排序命令
    加锁命令
架构
    常用的数据类型
    数据淘汰策略
    单线程的为什么那么快
    RDB和AOF的优缺点
    持久化策略选择
应用
    缓存雪崩、缓存穿透、缓存预热、缓存更新、缓存降级: 
        - https://mp.weixin.qq.com/s/_StOUX9Nu-Bo8UpX7ThZmg

    Pipeline有什么好处，为什么要用pipeline
        pipeline管道批量执行指令，可以节省多次IO往返的时间，但是如果指令间有依赖建议分批发送

    是否使用过Redis集群，集群的原理是什么
        （1）Redis Sentinal 着眼于高可用，在 master 宕机时会自动将 slave 提升为master，继续提供服务。
        （2）Redis Cluster 着眼于扩展性，在单个 redis 内存不足时，使用 Cluster 进行分片存储。
    Redis的同步机制了解么
        Redis 可以使用主从同步，从从同步。第一次同步时，主节点做一次 bgsave，并同时将后续修改操作记录到内存 buffer，待完成后将 rdb 文件全量同步到复制节点，复制节点接受完成后将 rdb 镜像加载到内存。加载完成后，再通知主节点将期间修改的操作记录同步到复制节点进行重放就完成了同步过程。


    redis 核心篇：https://mp.weixin.qq.com/s/8HN1PqqU57Kdz9ERwDY2cw
    redis 日志篇 RDB 和 AOF：https://mp.weixin.qq.com/s/R-jZnjGNbOOL6zOtVd9omg


    主从架构: https://mp.weixin.qq.com/s/pWf72S9Pd6HRWg5MUlpr8Q

    哨兵集群搭建: https://mp.weixin.qq.com/s/LZxKifLRFnqLiAeSSv7q9A
    哨兵集群原理: https://mp.weixin.qq.com/s/rtgh5c6p5zhcfgGeqX5mZA

    redis Cluster 原理: https://www.cnblogs.com/detectiveHLH/p/14154665.html

    内存耗尽后，Redis会发生什么：https://www.cnblogs.com/lonely-wolf/p/14403264.html
    布隆过滤器: https://www.cnblogs.com/lonely-wolf/p/14451302.html
    

    redis skiplist: https://zhuanlan.zhihu.com/p/23370124

    分布式锁用Redis还是Zookeeper：https://zhuanlan.zhihu.com/p/73807097
    Redis 锁与 Zookeeper 锁： https://mp.weixin.qq.com/s/4CUe7OpM6y1kQRK8TOC_qQ

    Redis 思维导图： https://www.processon.com/view/link/6084234d7d9c08118405ab50#map
    

MySQL
锁
    全局锁
    表锁
    行锁
    乐观锁、悲观锁
    排他锁
    锁优化
事务
    事物特征
    脏读
    幻读
    不可重复读
    事物隔离
    并发事物
    事务实现原理: https://cloud.tencent.com/developer/article/1431307
日志
    慢查询日志
    错误日志
    redo log(重做日志)
    binlog(归档日志)
    undo log(回滚日志)

    Redo Log 和 Binlog 介绍： https://mp.weixin.qq.com/s/XTpoYW--6PTqotcC8tpF2A
    七种日志: https://mp.weixin.qq.com/s/-v6CHvvAwtuznG-bzZKQ0w
    mysql 十连问： https://mp.weixin.qq.com/s/O_NHjv_YVUi4lSqXnhx5Mg

索引: 
    聚集索引 VS 非聚集索引: 
    覆盖索引(多字段索引)优化
    最左匹配原则: 
    前缀索引

    MyISAM 和 Innodb 区别: https://www.jianshu.com/p/c5cc4b634807
    图解MVCC 多版本并发控制: 
        - https://www.jianshu.com/p/b7f5f18cac94
        - https://www.jianshu.com/p/615f3c7fbe6f
        - https://cloud.tencent.com/developer/article/1693232


    mysql 索引原理详解：https://mp.weixin.qq.com/s/wiqfcVrsLgLvLbsTU-qSag
    如何正确的使用索引：https://mp.weixin.qq.com/s/Ruz3kFg00R9f935x_yuskQ
    mysql 如何确保数据不丢失, redo log: https://mp.weixin.qq.com/s/CU2G85qbIyBNfCnlkLGZfw


引擎
    InnoDB
    MyISAM
    InnoDB 和 MyISAM 存储引擎区别: 
    一棵 B+ 树中可以存多少数据

    MySQL 思维导图： https://www.processon.com/view/link/6083e2860791293ce8133312


4.3.1 Dubbo
    通信模型是什么样的
    Dubbo 和 Spring Cloud 有什么区别
    dubbo都支持什么协议，推荐用哪种 dubbo://（推荐） rmi:// hessian:// http:// webservice:// thrift:// memcached:// redis:// rest://
    Dubbo里面有哪几种节点角色
    Dubbo中怎么处理的超时断开

    RPC 调用和HTTP区别: https://mp.weixin.qq.com/s/mqKulTHTYNx_ks8-LVvJ5A

    源码解析: http://www.tianxiaobo.com/2018/10/01/Dubbo-源码分析-SPI-机制/
        - SPI 机制
        - 自适应拓展原理
        - 服务导出
        - 服务引用
        - 集群容错之Directory
        - 集群容错之Router
        - 集群容错之Cluster
        - 集群容错之LoadBalance
    

Zookeeper(CP)

    - CAP：https://www.ruanyifeng.com/blog/2018/07/cap.html
    - BASE: https://blog.csdn.net/ThreeAspects/article/details/104280517
      - Basically Available(基本可用)
      - Soft state(软状态)
      - Eventualy consisten(最终一致性)
    - 分布式事务，两阶段提交，三阶段提交


MQ
    ActiveMQ: https://www.bilibili.com/video/BV164411G7aB
        - Topic 和 Queue 对比: https://www.bilibili.com/video/BV164411G7aB?p=18


    RabbitMQ: https://www.bilibili.com/video/BV1up4y1i7TN
    


Java 面试： https://www.bilibili.com/video/BV1zb411M7NQ

网络相关：
    https://pan.baidu.com/s/1FfR8jpxdk6Bro23KddyU8A  密码: 9c4f


4.2.4 SpringCloud
    spring cloud 断路器的作用是什么
    spring cloud 的核心组件有哪些 Eureka：服务注册于发现。 Feign：基于动态代理机制，根据注解和选择的机器，拼接请求 url 地址，发起请求。 Ribbon：实现负载均衡，从一个服务的多台机器中选择一台。 Hystrix：提供线程池，不同的服务走不同的线程池，实现了不同服务调用的隔离，避免了服务雪崩的问题。 Zuul：网关管理，由 Zuul 网关转发请求给对应的服务。

    SpringCloud： https://www.bilibili.com/video/BV18E411x7eT


算法：
    快排
    二叉树
    B 树
    B+ 树: http://offer.liangsonghua.me/docs/basic/algo/tree/
    递归
    动态规划
    skipList
    
    树:
      http://offer.liangsonghua.me/docs/basic/algo/tree/
      堆的应用之ScheduledThreadPoolExecutor 中的 DelayedWorkQueue： https://mp.weixin.qq.com/s/CcChX0MvxkdlToaVQT1BOA
    
    Hash: http://offer.liangsonghua.me/docs/basic/algo/hash/

    KMP 算法: http://offer.liangsonghua.me/docs/basic/algo/kmp/

    跳跃表: http://offer.liangsonghua.me/docs/basic/algo/skip_list/


    算法可视化:
        - https://visualgo.net/
        - https://www.cs.usfca.edu/~galles/visualization/Algorithms.html

    CodeTop:
        - https://codetop.cc/#/home
    
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


设计模式：
    单例模式：
        懒汉式，饿汉式，存在问题及修复方案
    双重检查锁定与延迟初始化: https://www.infoq.cn/article/double-checked-locking-with-delay-initialization

    策略模式：
        - 卫语句：https://www.jianshu.com/p/e1dc84e96c43
        - 策略模式：https://my.oschina.net/u/4662964/blog/4723828
        - 责任链模式（管道模式）：https://my.oschina.net/u/4662964/blog/4759287

    模板模式:
        https://mp.weixin.qq.com/s/QBmDiyfST13nQJUcPLLXOg

    https://javadoop.com/post/design-pattern

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

**参考资料：**
- [小傅哥的面经手册](https://bugstack.cn/itstack/interview.html)
- [美团技术博客](https://tech.meituan.com/tags/java.html)
- [编了个程](https://yasinshaw.com/)
- [Java8-tutorial](https://github.com/winterbe/java8-tutorial)


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