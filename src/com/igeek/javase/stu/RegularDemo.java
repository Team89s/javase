package com.igeek.javase.stu;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/27 11:12
 *
 * 剑指offer：中等
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * ?
 *
 * 限制：
 *
 * 0 <= n <?2^31
 *
 *                          位数       数量                     所占位数
 *    1~9                   1          9 = 1 * 9                9 = 1 * 9
 *    10~99                 2          90 = 10 * 9              180 = 10 * 2 * 9
 *    100~999               3          900                      2700 = 100 * 3 * 9
 *    ~ 
 *    start ~ end           digit      numbers = start * 9        count = start * 9 * digit
 */
public class RegularDemo {
    public static void main(String[] args) {
        System.out.println(getNumber(110));
        System.out.println(get(110));
    }

    //n从0开始
    public static int getNumber(int n) {
        if (n != 0) {
            // i 代表位数
            for (int digit = 1; digit <= 10; digit++) {
               int start = (int) Math.pow(10,digit - 1);  //10
               int count = start * digit * 9;  //180
               //得到所在位数范围
               if (n - count <= 0) {
                   //得到位数范围内 n 位置所在的数
                   int number = start + n / digit - 1;  //10
                   //得到所在数中的下标
                   int num = n % digit; // 2%2=0

                   if (num == 0) {
                       return (number + "").charAt(digit - 1) - '0';
                   }else {
                        return (number + 1 + "").charAt(num -1) - '0';
                   }
               }
               n -= count;  //n=n-count  11-9=2
            }
        }
        return 0;
    }


    public static int get(int n) {
        int digit = 1;
        int start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n -1) % digit)  - '0';
    }




}
