package com.igeek.javase.day04.interfaces.test2;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/2 15:15
 */
public class Test {

    public static void main(String[] args) {

        Employee employee = new Employee("小强","无锡新区","10",50,5);
        Manager manager = new Manager("小强","无锡新区","10",50,5,"中级开发工程师");
        System.out.println(employee);
        System.out.println(manager);

        System.out.println("==========涨薪后===========");

        employee.addSalary();
        System.out.println(employee);
        manager.addSalary();
        System.out.println(manager);
    }

}
