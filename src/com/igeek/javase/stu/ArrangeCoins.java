package com.igeek.javase.stu;

import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author Fuxiaohai
 * @Date 2020/12/3 13:36
 * 题目：给你n个硬币，让你来排列
 * 让你得到一个完整的梯子的行数
 * n是一个32位无符号整数
 *
 * 例子：6个硬币
 * *
 * **
 * ***
 * 完整梯子数是2
 * d=1 a1 = 1 Sn = na1 + (((n-1)*n)*d)/2 <=n
 * x+ （(x-1)*x）/2 <= n
 * 2x + x*x -x <= 2n
 * X^2 + x - 2n <=0
 * x =( -b + 根号下：b^2 - 4ac)/2
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个大于0整数：");
        int n = sc.nextInt();
        System.out.println(method1(n));
        //System.out.println(method2(n));
    }

    /**
     *
     * @param n
     * @return
     * 梯子数：     0,1,2,3,4，..n
     * 对应的硬币数：0,1,3,6,10，..((n+1)*n)/2;
     * low = 0;
     * high = n;
     * mid = (high-low)/2+low
     * cost = ((mid+1)*mid)/2
     *
     *当low<=high的时候
     * 如果cost刚好就是等于我们的n
     * cost<n low = mid+1
     * cost>n high = mid -1
     */
    public static int method1(int n){
        int low =0;
        int high = n;
        while (low<=high){
            long mid = (high-low)/2+low;
            long cost = ((mid+1)*mid)/2;
            if (cost==n){
                return (int)mid;
            }else if (cost<n){
                low = (int)(mid +1);
            }else {
                high = (int)(mid-1);
            }
        }
        return high;
    }

    //通过等差数列方式：
    public static int method2(int n){
        long q = 4*1*(-2*n);
        return (int)(-1+Math.sqrt(1-q))/2;
    }
}

//long是 为了防止溢出的
