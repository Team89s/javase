package com.igeek.javase.day11.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/13 11:28
 *
 * JKD版本  LTS(long time support)
 *
 * JDK 9 的新特性：
 * list接口，Set接口 ，Map接口 里面 增加了一个静态方法 of，可以给集合一次性添加多个元素。
 * static <E> list<E> of ( E ... element )
 *
 * 使用前提：
 * -当集合中存储的元素的个数已经确定，不再改变使用
 *
 * 注意：
 * 1. of 方法只适用于，list接口，Set接口 ，Map接口 ， 不适应与接口的实现类
 * 2. of 方法的返回值是一个不能改变的集合，集合不能再使用 add,put方法添加元素，否则会抛出异常。
 * 3. Set接口和Map接口在调用 of 方法时，不能有重复的元素，否则会抛出异常
 *
 */
public class NewPointDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("aaa");
        set.add("bbb");

        //提供静态的工厂模式
        //Set<String> strString = Set.of("a","b","c");
        //List<Integer> list = List.of(10,20);
        //Map<String,Integer> map = Map.of("aaa",10,"bbb",20);

    }

}
