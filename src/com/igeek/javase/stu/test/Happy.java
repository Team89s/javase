package com.igeek.javase.stu.test;

import java.util.HashSet;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/15 13:35
 *
 * /**
 *  * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 *  「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 *  然后重复这个过程直到这个数变为 1，
 *  也可能是 无限循环 但始终变不到 1。如果 可以变为 1，那么这个数就是快乐数。
 *  如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *  * 示例：
 *  * 输入：19
 *  * 输出：true
 *  * 解释：
 *  * 1 + 81 = 82
 *  * 64 + 4 = 68
 *  * 36 + 64 = 100
 *  * 1 + 0 + 0 = 1
 *  *
 *
 *  16
 *  1 + 36 = 37
 *  9 + 49 = 58
 *  25 + 64 = 89
 *  64 + 81 = 145
 *  1 + 16 +25 = 42
 *  16 + 4 = 20
 *  4 + 0 = 4
 *  16
 *
 *  98  145 42 20 4 16 37 58 89 145
 *
 *
 *
 *
 *  * 输入：7
 *  * 输出：true
 *  * 解释：
 *  * 72 = 49
 *  * 42+92 = 97
 *  * 92+72 = 130
 *  * 12+32+02 = 10
 *  * 12+02 = 1
 */
public class Happy {
    public static void main(String[] args) {
        System.out.println(isHappy(1));
    }

    //计算各位上的平方和
    public static int getNext(int n){
        //计算各位平方和得到的下一个数
        int next = 0;

        //345
        while (n>0){
            //先拿最低位上的数字
            int d = n % 10;
            //拿到最低位上的数字后，去除最低位上的数字，以便下一次循环拿到更高一位的数字
            n = n / 10 ;
            //计算平方和
            next += d * d;
        }
        return next;
    }

    //判断是否是快乐数
    public static boolean isHappy(int n){
        //创建一个容器，HashSet
        HashSet<Integer> set = new HashSet<>();


        while (n!=1 && !set.contains(n)){
           //添加进容器中
            set.add(n);

            //计算平方和，拿到下一个数
            n = getNext(n);

        }

        return n==1;
    }
}
