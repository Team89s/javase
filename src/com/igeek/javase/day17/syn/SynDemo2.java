package com.igeek.javase.day17.syn;

/**
 * @version 1.0
 * @Description 线程安全 - 同步方法
 * @Author chenmin
 * @Date 2020/11/30 16:01
 *
 * 线程同步：解决线程安全的问题，当多条线程，访问共享资源，为了让资源不发生争抢现象，能够有序进行
 *
 * 同步方法  synchronized
 * public synchronized void 方法名(){
 *      //会引发线程安全的逻辑代码块
 * }
 *
 * 对象锁
 * 1.synchronized 修饰非静态方法，此时对象锁是 this
 *      若此时是同一个对象执行方法，则会发生"等待"现象
 *      若此时不是同一个对象执行方法，则会发生"争抢"现象
 *
 * 2.synchronized 修饰静态方法，此时对象锁 类名.class
 *      此时无论创建同一个对象，还是不同对象，都会发生"等待"现象
 */
public class SynDemo2 {

    public synchronized static void method1(){
        //System.out.println("method1()开始执行");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" - "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void method2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" - "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynDemo2 s1 = new SynDemo2();
        SynDemo2 s2 = new SynDemo2();

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
