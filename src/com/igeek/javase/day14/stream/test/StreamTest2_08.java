package com.igeek.javase.day14.stream.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //8.将员工按照工资由低到高排序，显示名字
 *
 * //9.将员工按照工资由高到低排序，显示名字
 *
 * //10.将员工按照工资由低到高（工资一样则按年龄由小到大）排序，显示名字
 */
public class StreamTest2_08 {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",25,5500,"江苏无锡","男"));
        list.add(new Employee("李四",18,11000,"江苏南京","女"));
        list.add(new Employee("王二",33,5500,"江苏常州","男"));
        list.add(new Employee("赵武",29,15000,"江苏苏州","男"));

        //8.将员工按照工资由低到高排序，显示名字
        System.out.println("-------将员工按照工资由低到高排序-------");
        list.stream().sorted(Comparator.comparingInt(Employee::getSalary)).
                map(Employee::getName).
                forEach(System.out::println);

        //9.将员工按照工资由高到低排序，显示名字
        System.out.println("-------将员工按照工资由高到低排序-------");
        list.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).
                map(Employee::getName).
                forEach(System.out::println);

        //10.将员工按照工资由低到高（工资一样则按年龄由小到大）排序，显示名字
        System.out.println("-----------将员工按照工资由低到高（工资一样则按年龄由大到小）排序-------------");
        list.stream().sorted(
                Comparator.comparingInt(Employee::getSalary).
                        thenComparingInt(Employee::getAge).reversed()
                ).
                map(Employee::getName).
                forEach(System.out::println);
    }

}
