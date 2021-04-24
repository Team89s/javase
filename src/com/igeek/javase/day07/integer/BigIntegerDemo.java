package com.igeek.javase.day07.integer;

import java.math.BigInteger;

/**
 * @version 1.0
 * @Description 大整数类型  BigInteger
 * @Author chenmin
 * @Date 2020/11/5 10:10
 *
 * BigInteger  作用：超过基本数据类型中的整型范围后，可以用大整数BigInteger来进行存储
 * 1.java.math.BigInteger
 * 2.Java大整数类BigInteger，继承于Number类并实现了Comparable接口
 * 3.构造方法：
 *      BigInteger(String val)
 * 4.常用方法：
 *      BigInteger.valueOf(long)
 *      add(BigInteger val) 返回其值为 (this + val) 的 BigInteger。
 *      subtract(BigInteger val) 返回其值为 (this - val) 的 BigInteger。
 *      multiply(BigInteger val) 返回其值为 (this * val) 的 BigInteger。
 *      divide(BigInteger val) 返回其值为 (this / val) 的 BigInteger。
 */
public class BigIntegerDemo {

    public static void main(String[] args) {
        int i1 = 12121212;
        int i2 = 34343434;
        int i3 = i1*i2;
        System.out.println("i3 = "+i3);

        //最常用的转换方法  整数类型 --> BigInteger类型
        BigInteger b1 = BigInteger.valueOf(i1);
        BigInteger b2 = BigInteger.valueOf(i2);
        BigInteger b3 = b1.multiply(b2);
        System.out.println("b3 = "+b3);
    }

}
