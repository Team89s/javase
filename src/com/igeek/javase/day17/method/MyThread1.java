package com.igeek.javase.day17.method;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/30 15:18
 */
public class MyThread1 extends Thread {

    public MyThread1(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("MyThread1开始");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }
        System.out.println("MyThread1结束");
    }
}
