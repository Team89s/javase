package com.igeek.javase.day10.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @Description List 常见迭代方式
 * @Author chenmin
 * @Date 2020/11/11 11:30
 *
 * List 常见迭代方式
 * 1.foreach
 * 2.通过下标get
 * 3.迭代器Iterator
 * 4.Lambda
 */
public class IterDemo {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(12);
        list.add(false);
        list.add("hello");
        list.add("hello");

        //1.foreach
        System.out.println("-------foreach---------");
        for (Object o : list) {
            System.out.println(o);
        }

        //2.通过下标获取
        System.out.println("-------get---------");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

        //3.迭代器
        System.out.println("-------迭代器---------");
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //4.Lambda
        System.out.println("-------Lambda---------");
        list.forEach(o -> {
            System.out.println(o);
        });
    }

}
