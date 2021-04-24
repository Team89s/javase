package com.igeek.javase.day17.thread.lambda;

/**
 * @version 1.0
 * @Description Thread  简化版本 - 线程类
 * @Author chenmin
 * @Date 2020/11/30 10:31
 */
public class ThreadDemo {

    //主线程  先启动
    public static void main(String[] args) {
        //创建的线程，并且启动执行任务
        new Thread("线程1"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+" i="+i);
                }
            }
        }.start();


        //main主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i="+i);
        }
    }

}
