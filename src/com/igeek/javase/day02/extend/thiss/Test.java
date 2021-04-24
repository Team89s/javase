package com.igeek.javase.day02.extend.thiss;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/28 14:43
 */
class Employee {
    String name = "员工";
}

class Boss extends Employee{
    String name = "领导";

    public void show(){
        //this 调用本类的成员变量
        System.out.println(this.name);  //领导
        //super 调用父类的成员变量
        System.out.println(super.name); //员工
    }
}

public class Test{
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.show();
    }
}
