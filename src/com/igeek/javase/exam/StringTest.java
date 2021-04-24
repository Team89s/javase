package com.igeek.javase.exam;

import org.junit.Test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/18 14:03
 */
public class StringTest {
    @Test
    public void testString(){
        long l1 = System.currentTimeMillis();
        String str = "a";
        for (int i = 0; i < 2000 ; i++) {
            str+=String.valueOf(i);
        }
        //System.out.println("String："+str);
        long l2 = System.currentTimeMillis();
        System.out.println("String +拼接 耗时："+(l2-l1)/1000.0+"s");
    }

    @Test
    public void testStringBuilder(){
        long l1 = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder("a");
        for (int i = 0; i < 2000 ; i++) {
            builder.append(String.valueOf(i));
        }
        //System.out.println("StringBuilder："+builder);
        long l2 = System.currentTimeMillis();
        System.out.println("StringBuilder拼接 耗时："+(l2-l1)/1000.0+"s");
    }

}
