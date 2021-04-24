package com.igeek.javase.day06.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 11:44
 */
public class Test2_02 {
    /**
     * 写代码验证使用SimpleDateFormat把日期转换为字符串的时候;
     * 创建SimpleDateFormat对象,比较消耗程序的执行性能
     */
    public static String testSimpleDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        return format;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        testSimpleDate(new Date());
        long now = System.currentTimeMillis();
        System.out.println(now - l);
    }


}
