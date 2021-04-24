package com.igeek.javase.day02.extend.employeetest;

/**
 * @version 1.0
 * @Description 经理类
 * @Author chenmin
 * @Date 2020/10/28 15:32
 */
public class Manager extends Employee{

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println(this.getName()+"管理酒店");
    }

    @Override
    public String toString() {
        return super.toString()+"Manager{" +
                "bonus=" + bonus +
                '}';
    }
}
