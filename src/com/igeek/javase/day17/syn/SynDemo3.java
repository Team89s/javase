package com.igeek.javase.day17.syn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Description 线程安全 - Lock锁
 * @Author chenmin
 * @Date 2020/11/30 16:01
 *
 * 线程同步：解决线程安全的问题，当多条线程，访问共享资源，为了让资源不发生争抢现象，能够有序进行
 *
 * Lock锁 也称同步锁
 * 1.java.util.concurrent.locks.Lock
 * 2.public void lock() :加同步锁。
 *   public void unlock():释放同步锁。
 * 3.注意，无论代码运行是否有出现异常，最终都要释放同步锁，finally完成释放同步锁
 */
public class SynDemo3 {
    //创建同步锁对象
    private final Lock lock = new ReentrantLock();

    public void method1(){
        //加同步锁
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" - "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放同步锁
            lock.unlock();
        }
    }

    public void method2(){
        //加同步锁
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" - "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放同步锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynDemo3 s1 = new SynDemo3();
        SynDemo3 s2 = new SynDemo3();

        new Thread("线程1"){
            @Override
            public void run() {
                s1.method1();
            }
        }.start();

        new Thread("线程2"){
            @Override
            public void run() {
                s2.method2();
            }
        }.start();
    }

}
