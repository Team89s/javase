package com.igeek.javase.day04.interfaces.test2;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/2 15:10
 */
public class Employee extends Person implements Add{
    private String id;
    private double wage;
    private int age;

    public Employee() {
    }

    public Employee(String name, String address, String id, double wage, int age) {
        super(name, address);
        this.id = id;
        this.wage = wage;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", wage=" + wage +
                ", age=" + age +
                "} " + super.toString();
    }

    @Override
    public void addSalary() {
        this.wage*=1.1;
    }
}
