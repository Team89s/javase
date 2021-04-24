package com.igeek.javase.day17.thread.lambda;

/**
 * @version 1.0
 * @Description 简化版本 -  Runnable接口
 * @Author chenmin
 * @Date 2020/11/30 10:54
 */
public class RunnableDemo {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+" i = "+i);
                }
            }
        },"线程1").start();


        //Lambda表达式
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" i = "+i);
            }
        },"线程2").start();

        //main线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }
    }

}
