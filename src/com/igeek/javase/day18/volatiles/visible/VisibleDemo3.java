package com.igeek.javase.day18.volatiles.visible;

/**
 * @version 1.0
 * @Description 可见性
 * @Author chenmin
 * @Date 2020/12/3 10:05
 *
 * 论题：
 *      多个线程访问共享变量，会出现一个线程修改变量的值后，其他线程看不到变量最新值的情况。
 * 总结：
 *      并发编程下，多线程修改变量，会出现线程间变量的不可见性。
 * 不可见性的原因：
 *      每个线程都有自己的工作内存，操作的共享变量并不是主内存中的，而是读过来的共享变量的副本。
 * ​
 *
 * 解决线程间变量的不可见性的方案有两种常见方式：
 *      方式一：加锁
 *          解决原因：清空线程的工作内存，从主内存拷贝共享变量最新的值到工作内存成为副本
 *      方式二：对共享的变量进行volatile关键字修饰
 *          解决原因：一旦一个线程中的变量，添加了volatile修饰符，有线程修改了此变量，
 *          其它线程会立即失效，当其它线程使用时可以立即读取主内存中的最新值至工作内存中使用
 *
 * volatile与synchronized的区别
 * 1.volatile关键字修饰变量（实例变量或类变量），synchronized关键字修饰方法（同步方法）或代码块（同步代码块）
 * 2.从性能上说，volatile更好点，仅仅是对实现线程间变量的可见性上
 * 3.volatile保证数据的可见性，但是不保证原子性(即：多线程进行写操作，不保证线程安全)；
 * 而synchronized是一种排他（互斥）的机制，实现线程安全。
 */
public class VisibleDemo3 {

    //启动主线程
    public static void main(String[] args) {
        //启动了一条线程
        MyThread3 my = new MyThread3();
        my.start();

        while(true){
            if(my.isFlag()){  //false->true
                System.out.println("main任务正在执行....");
            }
        }
    }

}

class MyThread3 extends Thread{
    //volatile 解决不可见性
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = "+flag);
    }
}
