package com.igeek.javase.day17.syn;

/**
 * @version 1.0
 * @Description 线程安全 - 同步代码块
 * @Author chenmin
 * @Date 2020/11/30 16:01
 *
 * 线程同步：解决线程安全的问题，当多条线程，访问共享资源，为了让资源不发生争抢现象，能够有序进行
 *
 * 第一种方式：同步代码块
 * `synchronized`关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
 *  synchronized(对象锁){
 *      //会引发线程安全的逻辑代码块
 *  }
 *
 *  对象锁
 *  1.引用数据类型  数组byte[0]  字符串"A"   this   类名.class
 *  2.多个线程对象  要使用同一把锁
 *  在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着
 *
 *  当多条线程访问共同资源时，发生了"争抢"现象，若要解决此现象，加上"同步锁"，产生"互斥效果"
 *  1.对象锁是 this   who执行此方法，who就是对象锁
 *  若此时是同一个对象执行方法，则会发生"等待"现象
 *  若此时不是同一个对象执行方法，则会发生"争抢"现象
 *
 *  2.对象锁是  "A"
 *  若此时是同一个对象执行方法，则会发生"等待"现象
 *  若此时不是同一个对象执行方法，则会发生"等待"现象
 *
 *  3.对象锁是  开销最小  byte[] bytes = new byte[0];
 *  若此时是同一个对象执行方法，则会发生"等待"现象
 *  若此时不是同一个对象执行方法，则会发生"争抢"现象
 *
 *  4.对象锁是  类名.class 类类型
 *  若此时是同一个对象执行方法，则会发生"等待"现象
 *  若此时不是同一个对象执行方法，则会发生"等待"现象
 */
public class SynDemo1 {

    //private byte[] bytes = new byte[0];

    public void method1(){
        System.out.println("method1()开始执行");

        synchronized (SynDemo1.class){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" - "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void method2(){
        synchronized(SynDemo1.class){
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" - "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SynDemo1 s1 = new SynDemo1();
        SynDemo1 s2 = new SynDemo1();

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
