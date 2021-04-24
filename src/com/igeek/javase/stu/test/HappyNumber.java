package com.igeek.javase.stu.test;

import java.util.HashSet;

/**
 * @version 1.0
 * @Description TODO
 * @Author scar 宋军宝
 * @Date 2020/12/16 8:50
 */
public class HappyNumber {
    public static void main(String[] args) {
       happy(7);
       happy(2);
    }

    public static int next(int n){
        int next=0;
        while (n>0){
            //求出最后一位的数
            int a=n%10;
            //将原数去掉最后一位
            n=a/10;
            //求出所有位的数的平方
            next+=a*a;
        }
        return next;
    }
    public static void happy(int n){
       // 创建容器 用于储存n
        HashSet<Integer>set=new HashSet();

        while (n!=1&&!set.contains(n)){
            //添加进集合
            set.add(n);
            //计算平方和
            n=next(n);
        }
        if (n==1){
            System.out.println("是happy数");
        }else {
            System.out.println("不是happy数");
        }
    }
}
