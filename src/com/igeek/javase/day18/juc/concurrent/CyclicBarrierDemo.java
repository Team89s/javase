package com.igeek.javase.day18.juc.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @Description 并发包 - CyclicBarrier类
 * @Author chenmin
 * @Date 2020/12/4 14:23
 *
 * CyclicBarrier类  同步辅助类  类似于“计数器”
 *
 * 构造方法：
 *      CyclicBarrier(int parties, Runnable barrierAction)
 *      第一个参数：parties  在启动 barrier 前必须调用 await() 的线程数
 *      第二个参数：barrierAction  回调函数，一旦达到parties的线程数，将执行指定的任务
 *
 *  常用方法：
 *      int await() 在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。  +1
 *
 *  CountDownLatch和 CyclicBarrier的区别
 *  1.CountDownLatch类似于倒计时的计数器 ； CyclicBarrier类似于累加的计数器
 *  2.CountDownLatch中的await(),让当前线程在计数器清零之前一直处于等待状态
 *  CyclicBarrier中的await(),累加的效果，直到达到定义的初始的CyclicBarrier中数量为止
 *  3.CountDownLatch调用完await()方法后，执行完毕，直接结束
 *  CyclicBarrier可以循环操作执行回调函数barrierAction
 *
 *  练习：公司召集5名员工开会，等5名员工都到了，会议开始。要求有一个主持会议的人。
 *  我们创建5个员工线程，1个开会线程，几乎同时启动，使用CyclicBarrier保证5名员工线程全部执行后，
 *  再执行开会线程。
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙！！！");
        });

        for (int i = 1; i <=14 ; i++) {
            int finalI = i;  //等价于 final int temp = i;
            new Thread(()->{
                System.out.println("目前已收集"+ finalI +"颗龙珠");
                try {
                    //计数器 +1
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"线程"+i).start();
        }

    }

}
