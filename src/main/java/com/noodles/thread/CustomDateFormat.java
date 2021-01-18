package com.noodles.thread;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 时间格式化
 * @Author: noodles
 * @create: 2021-01-18 08:29
 */
public class CustomDateFormat {

    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        int temp = BigDecimal.valueOf(Math.pow(2, 32) * 0.6180339887).intValue();
        System.out.println(temp);
        // 十六进制
        System.out.println(Integer.toString(temp, 16));
    }

    public static void notSafe() {
        while (true) {
            new Thread(() -> {
                String dateStr = f.format(new Date());
                try {
                    Date parseDate = f.parse(dateStr);
                    String dateStrCheck = f.format(parseDate);
                    boolean equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + dateStr + " " + dateStrCheck);
                        Thread.sleep(10000);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void safeMethod() {
        while (true) {
            new Thread(() -> {
                String dateStr = threadLocal.get().format(new Date());
                try {
                    Date parseDate = threadLocal.get().parse(dateStr);
                    String dateStrCheck = threadLocal.get().format(parseDate);
                    boolean  equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(dateStr + " !=" + dateStrCheck);
                        Thread.sleep(100);
                    } else {

                        System.out.println(equals);
                    }
                } catch (ParseException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
