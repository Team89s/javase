package com.igeek.javase.day14.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description 如何获取Stream流对象
 * @Author chenmin
 * @Date 2020/11/23 10:07
 */
public class StreamDemo2 {

    public static void main(String[] args) {
        //1.Collection集合
        System.out.println("-------- List --> Stream流 ------");
        Collection<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("bbb");
        Stream<String> listStream = list.stream();
        listStream.forEach(System.out::println);

        System.out.println("--------Set  --> Stream流 ------");
        Collection<String> set = new HashSet<>();
        set.add("123");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        Stream<String> setStream = set.stream();
        setStream.forEach(System.out::println);

        //2.Map集合
        Map<String,String> map = new HashMap<>();
        map.put("aaa","张三");
        map.put("ccc","李四");
        map.put("aaa","王五");
        System.out.println("--------map keySet() --> Stream流 ------");
        Set<String> keys = map.keySet();
        Stream<String> keyStream = keys.stream();
        keyStream.forEach(System.out::println);
        System.out.println("--------map values() --> Stream流 ------");
        Collection<String> values = map.values();
        Stream<String> valuesStream = values.stream();
        valuesStream.forEach(System.out::println);
        System.out.println("--------map entrySet() --> Stream流 ------");
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Stream<Map.Entry<String, String>> entryStream = entrySet.stream();
        entryStream.forEach(System.out::println);

        //3.数组
        System.out.println("--------数组 --> Stream流 ------");
        String[] strs = {"aaa","bbb","ccc","ccc"};
        Stream<String> stringStream = Arrays.stream(strs);
        stringStream.forEach(System.out::println);
        Stream<String> stream = Stream.of(strs);
        stream.forEach(System.out::println);
    }
}
