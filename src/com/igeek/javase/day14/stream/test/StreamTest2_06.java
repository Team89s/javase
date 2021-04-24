package com.igeek.javase.day14.stream.test;

import java.util.*;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //6.获取员工工资最高的人
 */
public class StreamTest2_06 {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",25,6600,"江苏无锡","男"));
        list.add(new Employee("李四",18,11000,"江苏南京","女"));
        list.add(new Employee("王二",33,5500,"江苏常州","男"));
        list.add(new Employee("赵武",29,15000,"江苏苏州","男"));

        Optional<Employee> emp = list.stream().max(Comparator.comparingInt(s -> s.getSalary()));
        System.out.println("最高工资的人："+emp.orElse(null));

        //Optional  map做了加工，将Employee -> String
        Optional<String> name = list.stream().max(Comparator.comparingInt(s -> s.getSalary())).map(a -> a.getName());
        System.out.println("最高工资的人："+name.orElse(""));
    }

}
