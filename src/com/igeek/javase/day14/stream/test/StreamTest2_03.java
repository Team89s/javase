package com.igeek.javase.day14.stream.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //3.筛选员工中工资高于8000的人，并形成新的集合
 */
public class StreamTest2_03 {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",25,6600,"江苏无锡","男"));
        list.add(new Employee("李四",18,11000,"江苏南京","女"));
        list.add(new Employee("王二",33,5500,"江苏常州","男"));
        list.add(new Employee("赵武",29,15000,"江苏苏州","男"));

        List<Employee> employees = list.stream().filter(x -> x.getSalary() > 8000).collect(Collectors.toList());
        System.out.println(employees);
    }

}
