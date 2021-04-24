package com.igeek.javase.day14.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 * @Description 函数式接口
 * @Author chenmin
 * @Date 2020/11/20 11:15
 *
 * 函数式接口 - 应用Lambda表达式使用
 * 优势：
 * 1.简化代码编写，例如：简化了匿名内部类的写法
 * 2.延迟加载效果，例如：满足级别后，日志写入
 */
public class FunctionnalDemo2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("abc");
        list.add("aaa");
        list.add("456");

        //Lambda表达式
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //简化1：
        list.forEach((String s) -> {
           System.out.println(s);
        });

        //简化2：
        list.forEach(s ->  System.out.println(s) );

        //简化3：方法引用，对Lambda表达式的进一步简化
        list.forEach(System.out::println);

    }
}
