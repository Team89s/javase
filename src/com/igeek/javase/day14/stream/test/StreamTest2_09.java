package com.igeek.javase.day14.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //11.求Integer集合中元素之和，乘积，最大值
 *
 * //12.求所有员工的工资之和，最高工资
 */
public class StreamTest2_09 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{6, 7, 3, 8, 1, 2, 9});
        //11.求Integer集合中元素之和，乘积，最大值
        Optional<Integer> optional1 = list.stream().reduce(Integer::sum);
        System.out.println("元素之和："+optional1.orElse(0));

        Optional<Integer> optional2 = list.stream().reduce((a, b) -> a * b);
        System.out.println("元素之积："+optional2.orElse(0));

        Optional<Integer> optional3 = list.stream().reduce(Integer::max);
        System.out.println("元素最大值："+optional3.orElse(0));


        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("张三",25,5500,"江苏无锡","男"));
        emps.add(new Employee("李四",18,11000,"江苏南京","女"));
        emps.add(new Employee("王二",33,5500,"江苏常州","男"));
        emps.add(new Employee("赵武",29,15000,"江苏苏州","男"));

        //12.求所有员工的工资之和，最高工资
        Integer sum = emps.stream().map(Employee::getSalary).reduce(0, Integer::sum);
        Integer max = emps.stream().map(Employee::getSalary).reduce(0, Integer::max);
        System.out.println("工资之和："+sum);
        System.out.println("最高工资："+max);
    }

}
