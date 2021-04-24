package com.igeek.javase.day07.integer;

/**
 * @version 1.0
 * @Description Integer类 - 字符串与基本数据类型之间的转换
 * @Author chenmin
 * @Date 2020/11/5 11:04
 */
public class IntegerDemo2 {

    public static void main(String[] args) {

        //1.将字符串转换成基本数据类型
        //static int parseInt(String s)  将字符串参数作为带符号的十进制整数。
        int i1 = Integer.parseInt("10");
        //java.lang.NumberFormatException: For input string: "10ab"  数字转化异常
        //int i2 = Integer.parseInt("10ab");
        System.out.println("i1 = "+i1);
        //十六进制 0-15  10~15用abcdef表示
        int i3 = Integer.parseInt("10ab", 16);
        System.out.println("i3 = "+i3);


        //2.将字符串转换成包装器类型
        //static Integer valueOf(String s)  返回一个 Integer对象持有指定的 String价值。
        Integer integer1 = Integer.valueOf("50");
        System.out.println("integer1 = "+integer1);
        Integer integer2 = Integer.valueOf("1111", 2);   //将2进制的数据转换成10进制
        Integer integer3 = Integer.valueOf("10ab", 16);  //将16进制的数据转换成10进制
        System.out.println("integer2 = "+integer2);  //15
        System.out.println("integer3 = "+integer3);  //4267

        //3.将基本数据类型转换成字符串
        System.out.println(10+"");
        System.out.println(String.valueOf(20));

        //4.将包装器类型转换成字符串
        System.out.println(new Integer(122).toString());
    }

}
