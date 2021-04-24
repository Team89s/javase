package com.igeek.javase.day18.juc.lock;

//8锁：关于锁的8个问题

//问题2：如下情况，两个线程启动，通过同一个对象调用其两个synchronized方法，第一个同步方法中添加沉睡3s，此时执行顺序？
//   答：学习  睡觉 （synchronized 直接修饰方法，代表当前对象锁是this，使用同一个对象调用方法，即是同一把对象锁。sleep()不会释放对象锁。）
public class Test2 {
    public static void main(String[] args) {
        Student2 stu = new Student2();

        new Thread(()-> stu.study(),"A").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> stu.sleep(),"B").start();
    }
}
class Student2{
    public synchronized void study(){
        //sleep()不会释放对象锁
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