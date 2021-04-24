package com.igeek.javase.day14.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description 将流对象Stream如何转变成集合/数组？
 * @Author chenmin
 * @Date 2020/11/23 11:31
 */
public class StreamDemo7 {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("成斌");
        list.add("傅总");
        list.add("小明");
        list.add("万青");
        list.add("小宝");
        list.add("小强");

        //将Stream流转成List集合
        Stream<String> listStream = list.stream().filter(s->s.contains("小"));
        System.out.println("--------将Stream流转成List集合---------");
        List<String> newList = listStream.collect(Collectors.toList());
        System.out.println(newList);

        //将Stream流转成Set集合
        Stream<String> setStream = list.stream().filter(s -> s.contains("小")).skip(1);
        System.out.println("--------将Stream流转成Set集合---------");
        Set<String> newSet = setStream.collect(Collectors.toSet());
        System.out.println(newSet);

        //将Stream流转成Map集合
        Stream<String> mapStream = list.stream().filter(s -> s.contains("小")).skip(1);
        Map<String, Student> newMap = mapStream.collect(Collectors.toMap(s -> s, Student::new));
        System.out.println(newMap);

        //将Stream流转成数组
        Stream<Integer> stream = Stream.of(10, 20, 30, 40);
        //Object[] objects = stream.toArray();
        //System.out.println(Arrays.toString(objects));

        Integer[] array = stream.toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
    }

}
