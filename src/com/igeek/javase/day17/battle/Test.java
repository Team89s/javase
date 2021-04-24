package com.igeek.javase.day17.battle;

import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/1 15:19
 *
 * wait()和sleep()两者区别
 * 1.Object类中的wait()  非静态的方法，属于对象的
 * Thread类中的sleep()   静态方法，属于当前线程的
 * 2.wait() 释放对象锁，sleep() 不会释放对象锁
 * 3.sleep()是可以不使用synchronized关键字的
 * wait()必须使用synchronized关键字的，否则出现java.lang.IllegalMonitorStateException异常
 * 4.sleep(long time) 不需要被唤醒，时间结束了自动醒
 * wait(long time) 时间结束类自动醒；但是wait()一直等待，直到被唤醒
 */
public class Test {

    public static void main(String[] args) {
        Object obj = new Object();

        Stream.of("线程1","线程2").forEach(n->new Thread(n){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+"线程开始执行");
                    try {
                        //Thread.sleep(3000);
                        obj.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程沉睡结束...");
                }
            }
        }.start());

    }

}
