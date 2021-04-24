package com.igeek.javase.stu.test;

/**
 * @Description TODO
 * @Author 叶录
 * @Date 2020/11/28 15:05
 */
public class RegularTest {
    public static int findNthDigit(int n) {
        //输入的是0-9都可以直接拿到结果
        if (n < 10) {
            return n;
        } else {
            int i = 1;
            while (n > i * (Math.pow(10, i - 1)) * 9) {
                n -= i * Math.pow(10, i - 1) * 9;
                i++;
            }
            //循环结束后,i-1就是位数,n-1为表示还要找多少个
            char[] result = String.valueOf((int) Math.pow(10, i - 1) + (n - 1) / i).toCharArray();//用字符串来接收值，方便找位数 result结果为要的那个数
            int value = result[(n - 1) % i] - '0';    //(n-1)%位数 得出要的第x位的数
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(100));
    }

}