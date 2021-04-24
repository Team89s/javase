package com.igeek.javase.day18.juc.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @Description 并发包 - CountDownLatch
 * @Author chenmin
 * @Date 2020/12/4 14:06
 *
 * CountDownLatch  同步辅助，类似于“倒计时的计数器”
 * 用法类似于Thread类中的join()，CountDownLatch允许一个或多个线程等待其他线程完成操作，再执行自己。
 *
 * 构造方法：
 *      CountDownLatch(int count) 构造一个用给定计数初始化的 CountDownLatch。
 * 常用方法：
 *      void await()  使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
 *      void countDown() 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
 * 总结：
 *      CountDownLatch是通过一个计数器来实现的，每当一个线程完成了自己的任务后，可以调用countDown()方法让计数器-1，
 *      当计数器到达0时，调用CountDownLatch的await()方法的线程阻塞状态解除，继续执行。
 *
 *  练习：线程1要执行打印：A和C，线程2要执行打印：B，
 *  但线程1在打印A后，要线程2打印B之后才能打印C，
 *  所以：线程1在打印A后，必须等待线程2打印完B之后才能继续执行。
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //电影院清场，构造方法中的参数，指的就是这个计数器的初始化值
        CountDownLatch count = new CountDownLatch(10);

        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"正在离场...");
                count.countDown(); //计数器 -1，直至减为0，则唤醒等待的线程
            },"线程"+i).start();
        }
        //在计数器清零之前会一直等待
        count.await();
        System.out.println("清场结束，大妈进场打扫...");
    }

}
