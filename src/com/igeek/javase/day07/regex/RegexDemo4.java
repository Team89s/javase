package com.igeek.javase.day07.regex;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description String中的split方法和replaceAll方法
 * @Author chenmin
 * @Date 2020/11/5 16:08
 */
public class RegexDemo4 {

    public static void main(String[] args) {

        String str = "小宝123abc小明qqq小强";
        //public String[] split(String regex)
        // 参数regex就是一个正则表达式。可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
        //System.out.println(Arrays.toString(str1.split("#")));
        System.out.println(Arrays.toString(str.split("\\w{1,}")));

        //public String replaceAll(String regex,String newStr)
        // 参数regex就是一个正则表达式。可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。
        String string = str.replaceAll("\\w+","abc123def");
        System.out.println(string);
    }

}
