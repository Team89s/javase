package com.igeek.javase.day04.interfaces.test2;

/*
2.
实现一个名为Person的类和它的子类Employee，Manager是Employee的子类，
设计一个接口Add用于涨工资，普通员工一次能涨10％，经理能涨20％。
具体要求如下：
（1）Person类中的属性有：
姓名name（String类型），地址address（String类型），定义该类的构造方法；　
（2）Employee类中的属性有：
工号ID（String型），工资wage（double类型），工龄（int型），定义该类的构造方法,
且重写该类toString()方法；　
（3）Manager类中的属性有：
级别level（String类型）定义该类的构造方法，且重写toString()方法；　
（4）编写一个测试类，产生一个员工和一个经理给该员工和经理涨工资，
并输出其具有的信息。　
*/
public interface Add {

    void addSalary();

}
