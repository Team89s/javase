package com.igeek.javase.day18.juc.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @version 1.0
 * @Description Semaphore类
 * @Author chenmin
 * @Date 2020/12/4 15:24
 *
 * Semaphore类
 * 作用与synchronized类似，synchronized可以起到"锁"的作用，但某个时间段内，只能有一个线程允许执行。
 * Semaphore可以设置同时允许几个线程执行。
 *
 * Semaphore 计数信号量  作用是控制访问特定资源的线程数目
 * 构造方法：
 *      Semaphore(int permits) 创建具有给定的许可数和非公平的公平设置的 Semaphore。
 *  常用方法：
 *       void acquire()  从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
 *       void release()  释放一个许可，将其返回给信号量。
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //Semaphore类似于 火车的入口闸门 ；permits个数为5，就相当于闸门个数为5
        Semaphore semaphore = new Semaphore(5);

        for (int i = 1; i <=10; i++) {
            new Thread(()->{
                try {
                    //获取入门的凭证
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"进站检查...");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"离开了闸门...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放入门的凭证
                    semaphore.release();
                }
            },"线程"+i).start();
        }
    }

}
