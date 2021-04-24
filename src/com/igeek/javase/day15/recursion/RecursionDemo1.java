package com.igeek.javase.day15.recursion;

/**
 * @version 1.0
 * @Description 递归
 * @Author chenmin
 * @Date 2020/11/24 11:13
 *
 * 递归
 *   1.规律性
 *      求1~n的和
 *      求1~n的乘
 *      猴子吃桃子的问题，第一天吃了一半多一个，第二天再吃一半多一个，第10天只剩余1个，请问第一天摘了多少个桃子？
 *   2.非规律性
 *      文件搜索
 *      文件删除
 *      喝啤酒问题，一瓶啤酒2元，两个空瓶子可以换一瓶啤酒，四个啤酒盖可以换一瓶啤酒，请问10元一共可以喝多少瓶？
 *
 * 总结：使用递归，要求必须要有终结点，否则会出现java.lang.StackOverflowError 堆栈溢出错误
 */
public class RecursionDemo1 {

    public static void main(String[] args) {
        System.out.println(f(10));
        System.out.println(method(10));
        System.out.println(sum(100));
        System.out.println(multiply(10));
    }

    /**
     * 规律性递归
     *
     * f(x) = f(x-1)+1
     * f(1) = 1
     * f(2) = f(1)+1 = 1+1
     * f(3) = f(2)+1 = 1+1+1
     * ...
     * f(10) = f(9)+1 = 1+1+1+1+1+1+1+1+1+1
     *
     *
     * 特点：
     * 1.公式    f(x) = f(x-1)+1
     * 2.终结点  f(1) = 1
     * 3.递归的方向，必须走向终结点
     *
     */
    public static int f(int x){
        if(x==1){
            return 1;
        }else{
            return f(x-1)+1;  //java.lang.StackOverflowError 堆栈溢出
        }
    }

    /**
     * 规律性递归
     *
     * 已知条件：f(x) = f(x+1)+2 ，  f(1) = 1
     * f(x-1) = f(x-1+1)+2
     * f(x-1) = f(x)+2
     * f(x) = f(x-1)-2
     *
     * f(1) = 1
     * f(2) = f(1)-2 = 1-2
     * f(3) = f(2)-2 = 1-2-2
     * ...
     * f(10) = f(9)-2 = -17
     *
     * 特点：
     * 1.公式    f(x) = f(x-1)-2
     * 2.终结点  f(1) = 1
     * 3.递归的方向，必须走向终结点
     */
    public static int method(int x){
        if(x==1){
            return 1;
        }else{
            return method(x-1)-2;
        }
    }


    /**
     * 求1~n的和   1+2+3+4+5+...+n
     *
     * f(1) = 1
     * f(2) = f(1)+2 = 1+2
     * f(3) = f(2)+3 = 1+2+3
     * f(4) = f(3)+4 = 1+2+3+4
     * ...
     * f(10) = f(9)+10 = 1+2+3+4+5+6+7+8+9+10
     * f(n) = f(n-1)+n
     *
     * 特点：
     *   1.公式    f(n) = f(n-1)+n
     *   2.终结点  f(1)=1
     *   3.递归的方向，必须走向终结点
     */
    public static int sum(int n){
        if(n==1){
            return 1;
        }else{
            return sum(n-1)+n;
        }
    }


    //求1~n的乘  乘阶
    public static int multiply(int n){
        if(n==1){
            return 1;
        }else{
            return multiply(n-1)*n;
        }
    }
}
