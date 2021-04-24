package com.igeek.javase.day10.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @version 1.0
 * @Description LinkedHashSet 类
 * @Author chenmin
 * @Date 2020/11/12 11:23
 *
 * LinkedHashSet
 * 1.不允许重复存放
 * 2.新增一条链表，来保证存取顺序一致
 * 3.由于保证了存取顺序，它的执行效率不如HashSet
 */
public class LinkedHashSetDemo {

    public static void main(String[] args) {
        //HashSet  存取顺序不一致
        HashSet<Object> hashset = new HashSet<>();
        hashset.add("小强");
        hashset.add(false);
        hashset.add("大宝");
        hashset.add(123);
        System.out.println(hashset);

        //LinkedHashSet  存取顺序一致
        LinkedHashSet<Object> set = new LinkedHashSet<>();
        set.add("小强");
        set.add(false);
        set.add("大宝");
        set.add(123);
        System.out.println(set);
    }

}
