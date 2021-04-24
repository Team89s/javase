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
 * 解决方式：
 *      方式一：加锁
 *          解决原因：清空线程的工作内存，从主内存拷贝共享变量最新的值到工作内存成为副本
 *      方式二：volatile关键字
 *          解决原因：
 */
public class VisibleDemo2 {

    //启动主线程
    public static void main(String[] args) {
        //启动了一条线程
        MyThread2 my = new MyThread2();
        my.start();

        while(true){
            //一旦进行加锁，清空线程的工作内存，就会拷贝主内存中最新的共享变量来到工作内存中
            synchronized ("A"){
                if(my.isFlag()){  //false->true
                    System.out.println("main任务正在执行....");
                }
            }
        }
    }

}

class MyThread2 extends Thread{
    private boolean flag = false;

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
