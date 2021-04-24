package com.igeek.javase.day15.recursion;

/**
 * @version 1.0
 * @Description 递归
 * @Author chenmin
 * @Date 2020/11/24 11:13
 *
 * 递归
 *   规律性
 *      猴子吃桃子的问题，第一天吃了一半多一个，第二天再吃一半多一个，第10天只剩余1个，请问第一天摘了多少个桃子？
 *
 */
public class RecursionTest1 {

    public static void main(String[] args) {
        System.out.println(f(1));
    }

    /**
     * 规律性递归
     *
     * f(x+1) = f(x) - f(x)/2 -1
     * 2f(x+1) = 2f(x)-f(x)-2
     * 2f(x+1)=f(x)-2
     * f(x)=2f(x+1)+2
     *
     * 特点：
     * 1.公式    f(x)=2f(x+1)+2
     * 2.终结点  f(10) = 1
     * 3.递归的方向，必须走向终结点
     */
    public static int f(int x){
        if(x==10){
            return 1;
        }else{
            return 2*f(x+1)+2;
        }
    }
}
