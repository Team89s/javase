package com.igeek.javase.day18.juc.concurrent.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @Description CyclicBarrier类
 * @Author chenmin
 * @Date 2020/12/4 15:12
 *
 * 练习：公司召集5名员工开会，等5名员工都到了，会议开始。要求有一个主持会议的人。
 * 我们创建5个员工线程，1个开会线程，几乎同时启动，使用CyclicBarrier保证5名员工线程全部执行后，
 * 再执行开会线程。
 */
public class Test2 {
    public static void main(String[] args) {
        //参加会议的人要求是5位，5位到齐，就开始会议
        CyclicBarrier barrier = new CyclicBarrier(5,new MeetingThread());

        //参加会议的人要求是5位
        for (int i = 1; i <=5 ; i++) {
            new EmpThread(barrier).start();
        }
    }
}
//会议线程
class MeetingThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"主持会议开始...");
    }
}
//员工线程
class EmpThread extends Thread{
    private CyclicBarrier barrier;

    public EmpThread(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"进入会议...");
        try {
            //相当于计数器累加 +1
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
