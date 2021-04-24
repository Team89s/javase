package com.igeek.javase.day14.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description 需求：筛选出班级中学生名字是三个字的学生，以张姓开头的信息
 * @Author chenmin
 * @Date 2020/11/23 9:39
 */
public class StreamDemo1 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("张小强");
        list.add("张路");
        list.add("成斌");
        list.add("张益达");
        list.add("傅总");
        list.add("毕大叔");

        //传统做法
        ArrayList<String> newList = new ArrayList<>();
        for (String s : list) {
            if(s.length()==3 && s.startsWith("张")){
                newList.add(s);
            }
        }
        System.out.println(newList);

        //Stream流
        Stream<String> stream = list.stream();
        stream.filter(str->str.length()==3).
                filter(a->a.startsWith("张")).
                forEach(System.out::println);
    }

}
