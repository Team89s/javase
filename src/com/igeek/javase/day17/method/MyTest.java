package com.igeek.javase.day17.method;

/**
 * @version 1.0
 * @Description Thread  - join() 等待方法
 * @Author chenmin
 * @Date 2020/11/30 15:18
 *
 * 确保了线程结束的顺序：
 * MyThread1结束
 * MyThread2结束
 * main结束
 */
public class MyTest {

    public static void main(String[] args) {
        System.out.println("main开始");

        MyThread1 my1 = new MyThread1("线程MyThread1");
        MyThread2 my2 = new MyThread2(my1,"线程MyThread2");
        my1.start();
        my2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }

        //主线程的结束，必须在my2执行完毕才能执行
        try {
            my2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main结束");
    }

}
