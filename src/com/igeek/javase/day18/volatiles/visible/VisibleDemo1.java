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
 *
 */
public class VisibleDemo1 {

    //启动主线程
    public static void main(String[] args) {
        //启动了一条线程
        MyThread my = new MyThread();
        my.start();

        while(true){
            if(my.isFlag()){  //false
                System.out.println("main任务正在执行....");
            }
        }
    }

}
class MyThread extends Thread{
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
