package com.igeek.javase.day14.stream.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:45
 */
public class Employee {

    private String name;
    private int age;
    private int salary;
    private String address;
    private String gender;

    public Employee() {
    }

    public Employee(String name, int age, int salary, String address, String gender) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.gender = gender;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "Employee{name = " + name + ", age = " + age + ", salary = " + salary + ", address = " + address + ", gender = " + gender + "}";
    }
}
