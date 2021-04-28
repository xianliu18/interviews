package com.noodles.aop.test;

import com.alibaba.fastjson.JSON;
import com.noodles.utils.FileUtil;
import com.noodles.utils.HashCode;
import com.noodles.utils.RateInfo;
import com.noodles.utils.TestDelayed;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ApiTest
 * @Description TODO
 * @Author noodles
 * @Date 2021/1/14 16:58
 */
@Slf4j
public class ApiTest {

    private Set<String> words;

//    @Before
    public void before() {
        // 读取文件
        System.out.println(System.getProperty("user.dir"));
        words = FileUtil.readWordList("./src/main/resources/103976个英语单词库.txt");
    }

    @Test
    public void test_collisionRate() {
        System.out.println("单词数量：" + words.size());
        List<RateInfo> rateInfoList = HashCode.collisionRateList(words, 2, 3, 5, 7, 17, 31, 32, 33, 39, 41, 199);
        for (RateInfo rate : rateInfoList) {
            System.out.println(String.format("乘数 = %d, 最小Hash = %11d， 最大Hash = %10d， 碰撞数量 = %6d， 碰撞概率 = %.4f%%", rate.getMultiplier(), rate.getMinHash(), rate.getMaxHash(), rate.getCollisionCount(), rate.getCollisionRate()));
        }
    }

    @Test
    public void test_hasArea() {
        System.out.println(HashCode.hashArea(words, 2).values());
        System.out.println(HashCode.hashArea(words, 7).values());
        System.out.println(HashCode.hashArea(words, 31).values());
        System.out.println(HashCode.hashArea(words, 32).values());
        System.out.println(HashCode.hashArea(words, 199).values());
    }

    @Test
    public void test_Iterator() {
        Map<String, String> map = new HashMap<>(64);
        map.put("24", "Idx: 2");
        map.put("46", "Idx: 2");
        map.put("68", "Idx: 2");
        map.put("29", "Idx: 7");
        map.put("150", "Idx: 12");
        map.put("172", "Idx: 12");
        map.put("194", "Idx: 12");
        map.put("271", "Idx: 12");

        System.out.println("排序01： ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }

        map.put("293", "Idx: 12");
        map.put("370", "Idx: 12");
        map.put("392", "Idx: 12");
        map.put("293", "Idx: 12");
        map.put("491", "Idx: 12");
        map.put("590", "Idx: 12");
        System.out.println("\n\n排序02： ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }

        map.remove("293");
        map.remove("370");
        map.remove("392");
        map.remove("491");
        map.remove("590");
        System.out.println("\n\n排序03： ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }
    }

    /***
     * @Description ArrayList
     *      参考连接：https://bugstack.cn/interview/2020/08/27/面经手册-第7篇-ArrayList也这么多知识-一个指定位置插入就把谢飞机面晕了.html
     */
    @Test
    public void test_ArrayList() {
        List<String> list = new ArrayList<>(10);
        list.add(2, "1");
        System.out.println(list.get(0));
    }

    @Test
    public void test_ArrayList_Remove() {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        Iterator<String> iter = a.iterator();
        while (iter.hasNext()) {
            String temp = iter.next();
            System.out.println("temp: " + temp);
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
    }

    @Test
    public void test_ArrayList_Transfer() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        System.out.println("通过数组转换：" + (list1.toArray().getClass() == Object[].class));

        System.out.println("数组转换的class为：" + list1.toArray().getClass());

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("通过集合转换：" + (list2.toArray().getClass() == Object[].class));
    }

    @Test
    public void test_Arraycopy() {
        int[] oldArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] newArr = new int[oldArr.length + (oldArr.length >> 1)];
        System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);

        newArr[11] = 11;
        newArr[12] = 12;
        newArr[13] = 13;
        newArr[14] = 14;

        System.out.println("数组元素：" + JSON.toJSONString(newArr));
        System.out.println("数组长度：" + newArr.length);
    }

    // i++ 测试
    @Test
    public void plus() {
        int i = 0;
        while (i++ < 5) {
            System.out.println("cal");
        }
        System.out.println(i);
    }

    @Test
    public void test_ArrayList_add() {
        List<String> list = new ArrayList<>(Collections.nCopies(9, "a"));
        System.out.println("初始化:" + JSON.toJSONString(list));

        list.add(2, "b");
        System.out.println("添加后：" + JSON.toJSONString(list));
    }

    @Test
    public void test_copy_remove1() {
        int[] oldArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = 2;
        int numMoved = 10 - index - 1;
        System.arraycopy(oldArr, index + 1, oldArr, index, numMoved);
        System.out.println("数组元素：" + JSON.toJSONString(oldArr));
    }

    @Test
    public void test_copy_remove2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(2);
        System.out.println(list.get(2));
    }


    @Test
    public void test_ArrayDeque() {
        Deque<String> deque = new ArrayDeque<String>(1);

        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");

        deque.offerLast("e");
        deque.offerLast("f");
        deque.offerLast("g");
        deque.offerLast("h");

        deque.push("i");
        deque.offerLast("j");

        System.out.println("数据出栈：");

        while (!deque.isEmpty()) {
            System.out.println(deque.pop() + " ");
        }
    }

    @Test
    public void test_arraycopy() {
        int head = 0, tail = 0;
        Object[] elements = new Object[8];
        elements[head = (head - 1) & (elements.length - 1)] = "a";
        elements[head = (head - 1) & (elements.length - 1)] = "b";
        elements[head = (head - 1) & (elements.length - 1)] = "c";
        elements[head = (head - 1) & (elements.length - 1)] = "d";

        elements[tail] = "e";
        tail = (tail + 1) & (elements.length - 1);
        elements[tail] = "f";
        tail = (tail + 1) & (elements.length - 1);
        elements[tail] = "g";
        tail = (tail + 1) & (elements.length - 1);
        elements[tail] = "h";
        tail = (tail + 1) & (elements.length - 1);

        System.out.println("head: " + head);
        System.out.println("tail: " + tail);

        int p = head;
        int n = elements.length;
        int r = n - p;

        System.out.println("扩容之前，数组：" + JSON.toJSONString(elements));

        // head == tail 扩容
        Object[] a= new Object[8 << 1];
        Object[] b= new Object[8 << 1];
        System.arraycopy(elements, p, a, 0, r);
        System.out.println("复制0到 r(" + r + ")数据：" + JSON.toJSONString(a));
        System.arraycopy(elements, 0, a, r, p);
        System.out.println("复制r到 p(" + p + ")数据：" + JSON.toJSONString(a));
        System.arraycopy(elements,0, b, 0, n);
        System.out.println("b 数组：" + JSON.toJSONString(b));

        elements = a;
        head = 0;
        tail = n;
        a[head = (head - 1) & (a.length - 1)] = "i";
        System.out.println(JSON.toJSONString(a));

    }

    @Test
    public void test_Deque_LinkedList() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");
        deque.offerLast("e");
        deque.offerLast("f");
        deque.offerLast("g");
        deque.offerLast("h");
        deque.push("i");
        deque.offerLast("j");

        System.out.println("数据出栈:");
        while (!deque.isEmpty()) {
            System.out.println(deque.pop() + " ");
        }
    }

    @Test
    public void test_DelayedQueue() throws InterruptedException {
        DelayQueue<TestDelayed> delayedQueue = new DelayQueue<>();
        delayedQueue.offer(new TestDelayed("aaa", 5, TimeUnit.SECONDS));
        delayedQueue.offer(new TestDelayed("ccc", 1, TimeUnit.SECONDS));
        delayedQueue.offer(new TestDelayed("bbb", 3, TimeUnit.SECONDS));

        log.info(((TestDelayed)delayedQueue.take()).getStr());
        log.info(((TestDelayed)delayedQueue.take()).getStr());
        log.info(((TestDelayed)delayedQueue.take()).getStr());
    }

    @Test
    public void test_binarySearch() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");

        int idx = Collections.binarySearch(list, "5");
        System.out.println("二分查找:" + idx);
    }

    @Test
    public void test_shuffle() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");

        Random random = new Random();
        for (int i = list.size(); i > 1; i--) {
            int ri = random.nextInt(i);
            int ji = i - 1;
            System.out.println("ri: " + ri + "\t ji: " + ji);
            list.set(ji, list.set(ri, list.get(ji)));
        }
        System.out.println(list);
    }

    @Test
    public void test_Rotate() {
        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("4");
        list.add("8");
        list.add("3");
        list.add("9");
        Collections.rotate(list, 2);
        System.out.println(list);
    }

    @Test
    public void test_Atomic() {
        AtomicInteger ai = new AtomicInteger(5);
        ai.getAndAdd(6);
        System.out.println(ai);
    }

    @Test
    public void test() {
        B b = new B();
        b.scan();
    }

    static class A {
        public void scan() {
            doScan();
        }
        protected void doScan() {
            System.out.println("A.doScan");
        }
    }

    static class B extends A {
        @Override
        protected void doScan() {
            System.out.println("B.doScan");
        }
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("jlkk", "uu");
        map.put("lopi", "mvp");
        map.put("jmdw", "mvp");
        map.put("e4we", "mvp");
        map.put("io98", "mvp");
        map.put("nmhg", "mvp");
        map.put("vfg6", "mvp");
        map.put("gfrt", "mvp");
        map.put("alpo", "mvp");
        map.put("vfbh", "mvp");
        map.put("bnhj", "mvp");
//        map.put("zuio", "mvp");
//        map.put("iu8e", "mvp");
//        map.put("yhjk", "mvp");
//        map.put("plop", "mvp");
//        map.put("dd0p", "mvp");
        System.out.println(map.get(null));
    }

    @Test
    public void test_MapTraversal() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果:");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }
    }

}
