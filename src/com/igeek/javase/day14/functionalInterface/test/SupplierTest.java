package com.igeek.javase.day14.functionalInterface.test;

import java.util.function.Supplier;

/**
 * @version 1.0
 * @Description Supplier
 * @Author chenmin
 * @Date 2020/11/20 14:52
 *
 * 求数组元素最大值，使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。
 */
public class SupplierTest {

    public static Integer getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        int max = getMax(() -> {
            int[] arr = {10, 25, 6, 32, 9};
            int num = arr[0];
            for (int a : arr) {
                if(a>num){
                    num = a;
                }
            }
            return num;
        });
        System.out.println("max = "+max);
    }

}
