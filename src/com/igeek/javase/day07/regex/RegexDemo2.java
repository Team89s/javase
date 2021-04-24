package com.igeek.javase.day07.regex;

/**
 * @version 1.0
 * @Description 一个字符 和 预定义字符
 * @Author chenmin
 * @Date 2020/11/5 16:08
 */
public class RegexDemo2 {

    public static void main(String[] args) {

        // [abc]：代表a或者b，或者c字符中的一个。
        System.out.println("a".matches("[abc]"));  //true
        System.out.println("q".matches("[abc]"));  //false
        System.out.println("3".matches("[abc]"));  //false

        // [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
        System.out.println("A".matches("[a-zA-Z0-9]"));  //true
        System.out.println("#".matches("[a-zA-Z0-9]"));  //false
        System.out.println("_".matches("[a-zA-Z_0-9]"));  //true
        System.out.println("-".matches("[a-zA-Z-0-9]"));  //true

        System.out.println("_".matches("\\w"));  //true
        System.out.println("#".matches("\\D"));  //true
        System.out.println("2".matches("\\d"));  //true
    }
}
