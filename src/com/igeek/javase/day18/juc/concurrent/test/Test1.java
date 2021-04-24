package com.igeek.javase.day18.juc.concurrent.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description CountDownLatch类
 * @Author chenmin
 * @Date 2020/12/4 15:03
 *
 * 练习：线程1要执行打印：A和C，线程2要执行打印：B，
 * 但线程1在打印A后，要线程2打印B之后才能打印C，
 * 所以：线程1在打印A后，必须等待线程2打印完B之后才能继续执行。  // A B C
 */
public class Test1 {

    public static void main(String[] args) {
        CountDownLatch countDown = new CountDownLatch(1);
        new MyThreadA("线程1",countDown).start();
        new MyThreadB("线程2",countDown).start();
    }

}
class MyThreadA extends Thread{
    private CountDownLatch countDown;
    public MyThreadA(String name,CountDownLatch countDown){
        super(name);
        this.countDown = countDown;
    }

    @Override
    public void run() {
        System.out.println("A");
        try {
            //等待状态，直到countDown()，将计数器减为0，再继续往下运行
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }
}
class MyThreadB extends Thread{
    private CountDownLatch countDown;
    public MyThreadB(String name,CountDownLatch countDown){
        super(name);
        this.countDown = countDown;
    }

    @Override
    public void run() {
        //线程沉睡
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");
        //B一输出，通知await不用再等待，可以继续执行
        countDown.countDown();  //类似于计数器-1，此时计数器清零
    }
}
