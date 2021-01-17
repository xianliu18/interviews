package com.noodles.aop.test;

import com.alibaba.fastjson.JSON;
import com.noodles.utils.FileUtil;
import com.noodles.utils.HashCode;
import com.noodles.utils.RateInfo;
import com.noodles.utils.TestDelayed;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
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

    @Test
    public void test_ArrayList() {
        List<String> list = new ArrayList<>(10);
        list.add(2, "1");
        System.out.println(list.get(0));
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

    @Test
    public void test_copy_remove() {
        int[] oldArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = 2;
        int numMoved = 10 - index - 1;
        System.arraycopy(oldArr, index + 1, oldArr, index, numMoved);
        System.out.println("数组元素：" + JSON.toJSONString(oldArr));
    }

    @Test
    public void test_ArrayList_addFirst() {
        ArrayList<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(0, i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_addFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.addFirst(i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_ArrayList_addLast() {
        ArrayList<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_addLast() {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.addLast(i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_ArrayList_addCenter() {
        ArrayList<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(list.size() >> 1, i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_addCenter() {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(list.size() >> 1, i);
        }
    }

    private LinkedList<Integer> list = new LinkedList<>();
    private int xx = 0;
    /**
     * @Description 初始化链表数组
     */
//    @Before
    public void init() {
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
    }

    @Test
    public void test_LinkedList_for0() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            xx += list.get(i);
            System.out.println(i);
        }
        System.out.println("for0 耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_for1() {
        long startTime = System.currentTimeMillis();
        for (Integer itr : list) {
            xx += itr;
            System.out.println(itr);
        }
        System.out.println("for1 耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_Iterator() {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer next = iter.next();
            xx += next;
            System.out.println(next);
        }
        System.out.println("iterator 耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_forEach() {
        long startTime = System.currentTimeMillis();
        list.forEach(integer -> {
            xx += integer;
            System.out.println(integer);
        });
        System.out.println("forEach 耗时：" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_LinkedList_stream() {
        long startTime = System.currentTimeMillis();
        list.stream().forEach(integer -> {
            xx += integer;
            System.out.println(integer);
        });
        System.out.println("Stream 耗时：" + (System.currentTimeMillis() - startTime));
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

        System.out.println(JSON.toJSONString(elements));

        // head == tail 扩容
        Object[] a= new Object[8 << 1];
        Object[] b= new Object[8 << 1];
        System.arraycopy(elements, p, a, 0, r);
        System.out.println(JSON.toJSONString(a));
        System.arraycopy(elements, 0, a, r, p);
        System.out.println(JSON.toJSONString(a));
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
    public void test_String() {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += i;
        }
        System.out.println("String 耗时:" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    @Test
    public void test_StringBuilder() {
        long startTime = System.currentTimeMillis();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            str.append(i);
            System.out.println(i);
        }
        System.out.println("StringBuilder 耗时" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    @Test
    public void test_StringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 10000000; i++) {
            str.append(i);
            System.out.println(i);
        }
        System.out.println("StringBuffer 耗时:" + (System.currentTimeMillis() - startTime) + "耗时");
    }

    @Test
    public void test_initStr() {
        String str_01 = "abc";
        System.out.println("默认方式:" + str_01);

        String str_02 = new String(new char[]{'a', 'b', 'c'});
        System.out.println("char方式:" + str_02);

        String str_03 = new String(new int[]{0x61, 0x62, 0x63}, 0, 3);
        System.out.println("int 方式:" + str_03);

        String str_04 = new String(new byte[]{0x61, 0x62, 0x63});
        System.out.println("byte 方式:" + str_04);
    }

    @Test
    public void test_strEqual() {
        String str_1 = new String("ab");
        String str_2 = new String("ab");
        String str_3 = "ab";

        System.out.println(str_1 == str_2);
        System.out.println(str_1 == str_2.intern());
        System.out.println(str_1.intern() == str_2.intern());
        System.out.println(str_1 == str_3);
        System.out.println(str_1.intern() == str_3);
    }

}
