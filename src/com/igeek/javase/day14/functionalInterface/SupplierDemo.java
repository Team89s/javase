package com.igeek.javase.day14.functionalInterface;

import java.util.function.Supplier;

/**
 * @version 1.0
 * @Description Supplier<T>
 * @Author chenmin
 * @Date 2020/11/20 14:40
 *
 * Supplier<T>  函数式接口
 * 1. T get()
 * 2.供给性
 * 特点：使用其get()，可以返回一个与接口泛型一致的数据
 */
public class SupplierDemo {

    public static String testSupplier(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        //匿名内部类
        testSupplier(new Supplier<String>() {
            @Override
            public String get() {
                return "a"+"b";
            }
        });

        //简化Lambda表达式
        String s = testSupplier(() -> {
            String str = "abc".toUpperCase();
            return str;
        });
        System.out.println(s);
    }

}
