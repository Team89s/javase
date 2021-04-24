package com.igeek.javase.day03.abstracts;

/**
 * @version 1.0
 * @Description 测试员工案例
 * @Author chenmin
 * @Date 2020/10/30 16:24
 */
public class Test {

    public static void main(String[] args) {
        //Employee employee = new Employee();
        Manager manager = new Manager(1,"小宝",30,50);
        manager.work();

        //多态  父类的引用指向子类的实例
        Employee xiaoBao = new Manager(2,"大宝",35,60);
        xiaoBao.work();
    }

}
