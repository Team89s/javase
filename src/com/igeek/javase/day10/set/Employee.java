package com.igeek.javase.day10.set;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/12 14:11
 */
public class Employee implements Comparable<Employee>{  //Employee实现Comparable比较器，此时Employee将具备比较性

    private String name;
    private double salary;


    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee{name = " + name + ", salary = " + salary + "}";
    }

    //TreeSet 保证元素唯一性，通过compareTo()比较结果，若结果为0，则直接认定两个元素是同一元素
    @Override
    public int compareTo(Employee o) {
        int result = new Double(this.salary).compareTo(o.salary);
        if(result==0){
            return this.name.compareTo(o.name);
        }
        return result;  //默认升序排列
    }
}
