package com.igeek.javase.day17.dead;

/**
 * @version 1.0
 * @Description 死锁
 * @Author chenmin
 * @Date 2020/12/1 16:40
 *
 * 死锁造成的原因
 * 1.在多线程中使用了多把锁，相互持有对方资源
 * 2.嵌套 Synchronized
 *
 * 如何解决死锁
 * 1.尽量不要使用嵌套的Synchronized语句
 * 2.不要相互持有对方资源，可以持有独立的资源
 *
 */
public class MyThread2 implements Runnable {

    private String a;
    private String b;

    public MyThread2(String a, String b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println("MyThread2开始执行...");
        synchronized (a+b){
            System.out.println("需要持有b资源做操作");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //synchronized (a){
                System.out.println("需要持有a资源做操作");
            //}
        }
        System.out.println("MyThread2结束执行...");
    }
}
