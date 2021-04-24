package com.igeek.javase.day18.volatiles.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Description CAS  Compare And Swap
 * @Author chenmin
 * @Date 2020/12/3 16:14
 */
public class CASDemo1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);

        //compareAndSet(expect期望值 , update更新值)  一旦期望值与主内存中的值相等，则更新，返回true；否则不更新返回false
        System.out.println(atomicInteger.compareAndSet(10, 11)); //true
        //获取最新的值
        System.out.println(atomicInteger.get());  //11
    }

}
