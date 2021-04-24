package com.igeek.javase.day02.has;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/29 14:00
 */
public class Person {

    private String name;

    /**
     * 关联关系  has - a   代码复用
     *
     * 概念：一个类作为另外一个类的属性的类型存在
     * 一对一 oo  关联一个对象
     * 一对多 om  关联数组或者关联集合
     *
     * 单向关联还是双向关联
     *
     * 强关联（组合关系）和弱关联（聚合关系）
     *
     */
    //一对一关联  单向关联
    private Phone phone;

    public Person() {
    }

    public Person(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }


    public void play(){
        System.out.println(name+"买了一部"+phone.getLabel());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
