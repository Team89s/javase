package com.igeek.javase.day14.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description Stream流对象的常用方法 - concat()组合
 * @Author chenmin
 * @Date 2020/11/23 10:07
 *
 * 链式操作：返回对象可以继续操作Stream的方法
 * 终结方法：forEach、count
 * 非终结方法：filter、limit、skip、map、concat，可以产生链式调用
 */
public class StreamDemo6 {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("成斌");
        list.add("傅总");
        list.add("万青");
        list.add("小宝");

        //将集合转成流对象
        Stream<String> listStream = list.stream();
        //创建流对象
        Stream<Integer> stream = Stream.of(10, 20, 30, 40);
        //concat 组合
        Stream<Object> concat = Stream.concat(listStream, stream);
        concat.forEach(System.out::println);
    }
}
