package com.igeek.javase.day04.interfaces.test2;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/2 15:10
 */
public class Manager extends Employee {

    private String level;

    public Manager() {
    }

    public Manager(String name, String address, String id, double wage, int age, String level) {
        super(name, address, id, wage, age);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "level='" + level + '\'' +
                "} " + super.toString();
    }

    @Override
    public void addSalary() {
        this.setWage(this.getWage()*1.2);
    }
}
