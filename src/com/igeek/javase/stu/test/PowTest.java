package com.igeek.javase.stu.test;

/**
 * @version 1.0
 * @Description pow(x,n)  幂次方
 * @Author WK 王康
 * @Date 2020/11/25 13:53
 */

public class PowTest {
    public static void main(String[] args) {
        System.out.println(myPow(2, -1));
        System.out.println(pow(2, -7));
    }
    //普通方法
    public static double myPow(double x, int n){
        //任意数值的0次方都为1
        if(n==0){
            return 1;
        }

        //0的任意次方（除0的0次方）都为0
        if(x==0){
            return 0;
        }

        //1的任意次方都为1
        if(x==1){
            return 1;
        }
        //指数为负时
        if(n<0){
            x=1/x;
            n=-n;
        }
        return myPow(x,n-1)*x;
    }

    //利用二分法思想
    public static double pow(double x,int n){
        //任意数值的0次方都为1
        if(n==0){
            return 1;
        }

        //0的任意次方（除0的0次方）都为0
        if(x==0){
            return 0;
        }

        //1的任意次方都为1
        if(x==1){
            return 1;
        }

        //n为正数时递归的出口
        if(n==1){
            return x;
        }
        //n为负数时递归的出口
        if(n==-1){
            return 1/x;
        }

        //指数为负时
        if(n<0){
            x=1/x;
            n=-n;
        }
        double half=pow(x,n/2);
        double rest=pow(x,n%2);
        return half*half*rest;
    }
}
