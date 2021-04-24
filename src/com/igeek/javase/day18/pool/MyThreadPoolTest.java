package com.igeek.javase.day18.pool;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 20:33
 */
public class MyThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 30,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <=6; i++) {
            System.out.println("添加第"+i+"个任务");
            //执行任务
            executor.execute(new MyThread("线程"+i));
            //迭代了等待队列中的任务
            Iterator iterator = executor.getQueue().iterator();
            while (iterator.hasNext()){
                MyThread thread = (MyThread) iterator.next();
                System.out.println("阻塞任务队列："+thread.name);
            }
        }
    }
}
class MyThread implements Runnable {
    String name;
    public MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:"+Thread.currentThread().getName() +" 执行:"+name +"  run");
    }
}
