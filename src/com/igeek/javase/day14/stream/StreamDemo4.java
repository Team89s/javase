package com.igeek.javase.day14.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description Stream流对象的常用方法 - filter过滤和skip跳过几个元素、count统计个数
 * @Author chenmin
 * @Date 2020/11/23 10:07
 *
 * 链式操作：返回对象可以继续操作Stream的方法
 * 终结方法：forEach、count
 * 非终结方法：filter、limit、skip，可以产生链式调用
 */
public class StreamDemo4 {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("cac");
        list.add("ccc");
        list.add("bab");

        //将集合转成流对象
        Stream<String> listStream = list.stream();
        //filter过滤方法
        //skip跳过几个元素
        //count统计个数
        long count = listStream.filter(a -> a.startsWith("c")).skip(1).count();
        System.out.println(count);
    }
}
