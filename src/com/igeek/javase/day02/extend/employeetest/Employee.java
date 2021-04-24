package com.igeek.javase.day02.extend.employeetest;

/**
 * @version 1.0
 * @Description 员工类
 * @Author chenmin
 * @Date 2020/10/28 15:32
 */
public class Employee {

    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void work(){
        System.out.println(name+"正在工作...");
    }

    //重写toString
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
