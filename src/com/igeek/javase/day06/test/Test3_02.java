package com.igeek.javase.day06.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 14:37
 *
 * 分别使用String的+= 和StringBuilder的append方法对字符串做100000次拼接,
 * 计算String拼接100000次花费时间与StringBuilder拼接100000次所花费时间并打印
 *
 * 结论：StringBuilder 效率高
 */
public class Test3_02 {

    public static void main(String[] args) {

        long timeString = Test3_02.testString();
        System.out.println("timeString = "+timeString);  //33012

        long timeStringBuilder= Test3_02.testStringBuilder();
        System.out.println("timeStringBuilder = "+timeStringBuilder);  //4
    }

    public static long testString(){
        long l1 = System.currentTimeMillis();
        String str = "hello";
        for (int i = 0; i < 100000; i++) {
            str+=" world";  //拼接 开辟内存存储新的字符串
        }
        long l2 = System.currentTimeMillis();
        return l2-l1;
    }

    public static long testStringBuilder(){
        long l1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("hello");
        for (int i = 0; i < 100000; i++) {
           sb.append(" world");
        }
        long l2 = System.currentTimeMillis();
        return l2-l1;
    }

}
