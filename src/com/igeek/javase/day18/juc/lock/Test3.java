package com.igeek.javase.day18.juc.lock;

import java.util.concurrent.TimeUnit;

//8锁：关于锁的8个问题

//问题3：如下情况，两个线程启动，通过两个对象调用其两个synchronized方法，此时执行顺序？
//   答：睡觉  学习 （两把对象锁，竞争资源）
public class Test3 {
    public static void main(String[] args) {
        Student3 stu1 = new Student3();
        Student3 stu2 = new Student3();

        new Thread(()-> stu1.study(),"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> stu2.sleep(),"B").start();
    }
}
class Student3{
    public synchronized void study(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("学习");
    }

    public synchronized void sleep(){
        System.out.println("睡觉");
    }
}
