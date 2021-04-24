package com.igeek.javase.day18.pool;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/1 15:56
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行...");
    }
}
