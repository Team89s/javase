package com.igeek.javase.day18.juc.lock;

//8锁：关于锁的8个问题

//问题1：如下情况，两个线程启动，通过同一个对象调用其两个synchronized方法，此时执行顺序？
//   答：学习  睡觉 （synchronized 直接修饰方法，代表当前对象锁是this，使用同一个对象调用方法，即是同一把对象锁）
public class Test1 {
    public static void main(String[] args) {
        Student1 stu = new Student1();

        new Thread(()-> stu.study(),"A").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> stu.sleep(),"B").start();
    }
}
class Student1{
    //synchronized 直接修饰方法，代表当前对象锁是this
    public synchronized void study(){
        System.out.println("学习");
    }
    public synchronized void sleep(){
        System.out.println("睡觉");
    }
}

