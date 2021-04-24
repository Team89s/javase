package com.igeek.javase.day18.juc.lock;

import java.util.concurrent.TimeUnit;

//8锁：关于锁的8个问题

//问题5：如下情况，两个线程启动，通过一个对象调用其两个静态的synchronized方法，此时执行顺序？
//   答：学习  睡觉（静态的同步方法  此时对象锁是类的字节码文件  Student5.class）

//问题6：如下情况，两个线程启动，通过两个对象调用其两个静态的synchronized方法，此时执行顺序？
//   答：学习  睡觉（静态的同步方法  此时对象锁是类的字节码文件  Student5.class）
public class Test5 {
    public static void main(String[] args) {
        Student5 stu1 = new Student5();
        Student5 stu2 = new Student5();

        new Thread(()-> stu1.study(),"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()-> stu2.sleep(),"B").start();
    }
}
class Student5{
    //静态的同步方法  此时对象锁是类的字节码文件  Student5.class
    public synchronized static void study(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("学习");
    }
    //静态的同步方法
    public synchronized static void sleep(){
        System.out.println("睡觉");
    }
}
