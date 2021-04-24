package com.igeek.javase.day03.abstracts;

/**
 * @version 1.0
 * @Description 员工类
 * @Author chenmin
 * @Date 2020/10/30 16:22
 */
public abstract class Employee {

    //工号,姓名,年龄,工资
    private int num;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int num, String name, int age, double salary) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //工作方法(work)
    public abstract void work();

    @Override
    public String toString() {
        return "Employee{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
