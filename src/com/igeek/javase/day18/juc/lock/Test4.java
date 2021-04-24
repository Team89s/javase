package com.igeek.javase.day18.juc.lock;

import java.util.concurrent.TimeUnit;

//8锁：关于锁的8个问题

//问题4：如下情况，两个线程启动，通过一个对象调用其synchronized方法，另一个对象调用非同步方法，此时执行顺序？
//   答：吃饭  学习（非同步方法，不受锁控制）
public class Test4 {
    public static void main(String[] args) {
        Student4 stu = new Student4();

        new Thread(()-> stu.study(),"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> stu.eat(),"B").start();
    }
}
class Student4{
    //同步方法
    public synchronized void study(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("学习");
    }
    //同步方法
    public synchronized void sleep(){
        System.out.println("睡觉");
    }
    //非同步方法
    public void eat(){
        System.out.println("吃饭");
    }
}
