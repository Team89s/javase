package com.igeek.javase.day18.juc.list;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Description 集合不安全
 * @Author chenmin
 * @Date 2020/12/4 10:41
 *
 * 多线程并发访问HashMap集合时，出现了线程不安全的情况，java.util.ConcurrentModificationException 并发修改异常
 */
public class ConcurrentHashMapDemo1 {

    //static Map<String,String> map = new Hashtable<>();  //2220
    static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();  //1555

    public static void main(String[] args) throws InterruptedException {
        MyThread my1 = new MyThread("线程1");
        MyThread my2 = new MyThread("线程2");
        my1.start();
        my2.start();

        my1.join();
        my2.join();

        //确保main主线程这个获取map的长度一定时最后再执行
        System.out.println("map的长度："+map.size());
    }

}
class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i <1000000 ; i++) {
            ConcurrentHashMapDemo1.map.put(Thread.currentThread().getName()+"-"+i,"abc"+i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"执行时间："+(l2-l1));
    }
}
