package com.igeek.javase.day06.test;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 13:49
 *
 * 使用正则表达式切割字符串
 * 192.168.105.27 按照  . 号切割字符串
 * 18 22 40 65 按照空格切割字符串
 */
public class Test2_03 {

    public static void main(String[] args) {

        String str1 = "192.168.105.27";
        String str2 = "18  22    40 65";

        String[] strings1 = str1.split("\\.");
        System.out.println(Arrays.toString(strings1));

        String[] strings2 = str2.split("\\s+");
        System.out.println(Arrays.toString(strings2));
    }

}
