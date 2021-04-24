package com.igeek.javase.day18.juc.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @version 1.0
 * @Description Exchanger类
 * @Author chenmin
 * @Date 2020/12/4 15:35
 *
 * Exchanger<V>类  交换者，是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。
 *
 * 构造方法：
 *      Exchanger()  创建一个新的 Exchanger。
 * 常用方法:
 *       V exchange(V x) 等待另一个线程到达此交换点（除非当前线程被中断），然后将给定的对象传送给该线程，并接收该线程的对象。
 *       V exchange(V x, long timeout, TimeUnit unit)  等待另一个线程到达此交换点（除非当前线程被中断，或者超出了指定的等待时间），然后将给定的对象传送给该线程，同时接收该线程的对象
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new BoyThread("傅总",exchanger).start();
        new GirlThread("桂太",exchanger).start();
    }
}
//BoyThread 男孩线程
class BoyThread extends Thread{
    private Exchanger<String> exchanger;

    public BoyThread(String name, Exchanger<String> exchanger){
        super(name);
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        //交换零食
        try {
            Thread.sleep(6000);
            String str = exchanger.exchange(Thread.currentThread().getName() + "给出零食A");
            System.out.println(Thread.currentThread().getName()+"收到--->"+str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//GirlThread  女孩线程
class GirlThread extends Thread{
    private Exchanger<String> exchanger;

    public GirlThread(String name, Exchanger<String> exchanger){
        super(name);
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        //交换零食
        try {
            //String str = exchanger.exchange(Thread.currentThread().getName() + "给出零食B");
            //指定交换时间5s，若5s内没有交换零食，则抛出异常java.util.concurrent.TimeoutException
            String str = exchanger.exchange(Thread.currentThread().getName() + "给出零食B",5, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName()+"收到--->"+str);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
