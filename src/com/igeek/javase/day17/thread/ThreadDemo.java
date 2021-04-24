package com.igeek.javase.day17.thread;

/**
 * @version 1.0
 * @Description Thread  线程类
 * @Author chenmin
 * @Date 2020/11/30 10:31
 *
 * 创建线程的方式一 - 继承 extends Thread
 * 1.自定义一个类继承Thread类
 * 2.重写run方法，run()定义的就是线程需要执行的任务
 * 3.创建线程对象
 * 4.真正启动线程，调用线程的start()，底层其实是给CPU注册当前线程，并触发run()方法执行
 * 进入可运行状态，开始争抢时间片，一旦争抢到时间片，就会进入到运行状态，执行run()中的任务
 *
 * 优点：代码很简洁
 * 缺点：Java单继承，一旦继承了一个类，想要再拓展再继承别的类是不被允许的
 */
public class ThreadDemo {

    //主线程  先启动
    public static void main(String[] args) {
        //new 线程 ->  新建状态
        MyThread my = new MyThread();
        my.setName("线程1");

        //真正启动线程  线程1来完成  -> 可运行状态
        my.start();

        //主main线程来完成
        //my.run();
        for (int i = 0; i < 10; i++) {
            //Thread.currentThread() 获得当前正在执行的线程信息
            System.out.println(Thread.currentThread().getName()+" i="+i);
        }
    }

}

//线程类
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //Thread.currentThread() 获得当前正在执行的线程信息
            System.out.println(Thread.currentThread().getName()+" i="+i);
        }
    }
}
