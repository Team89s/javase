package com.igeek.javase.day18.juc.lock;

import java.util.concurrent.TimeUnit;

//8锁：关于锁的8个问题

//问题7：如下情况，两个线程启动，通过同一个对象调用其静态的synchronized方法，调用其非静态的synchronized方法，此时执行顺序？
//   答：睡觉 学习 （静态的同步方法，此时对象锁是Student6.class；非静态的同步方法，此时对象锁是this）

//问题8：如下情况，两个线程启动，通过一个对象调用其静态的synchronized方法，另一个对象调用其非静态的synchronized方法，此时执行顺序？
//   答：睡觉 学习 （静态的同步方法，此时对象锁是Student6.class；非静态的同步方法，此时对象锁是this）
public class Test6 {
    public static void main(String[] args) {
        Student6 stu1 = new Student6();
        Student6 stu2 = new Student6();

        new Thread(()-> stu1.study(),"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> stu2.sleep(),"B").start();
    }
}
class Student6{
    //静态的同步方法  此时对象锁是Student6.class
    public synchronized static void study(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("学习");
    }
    //非静态的同步方法  此时对象锁是this
    public synchronized void sleep(){
        System.out.println("睡觉");
    }
}
