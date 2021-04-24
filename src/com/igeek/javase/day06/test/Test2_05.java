package com.igeek.javase.day06.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 14:22
 */

/**
 * 通过代码实现:
 * 把字符串 "Hello12345World6789012" 中所有数字替换为 "#"
 * 提示: 字符串类的replaceAll(String regex,string str)方法,使用str替换掉当前字符串中所有与正则表达式匹配的字符
 */
public class Test2_05 {
    public static void main(String[] args) {
        String str = "Hello12345World6789012";
        String str1 = str.replaceAll("\\d+","#");
        System.out.println(str1); //Hello#World#
    }
}
