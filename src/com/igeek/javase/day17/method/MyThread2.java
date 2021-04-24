package com.igeek.javase.day17.method;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/30 15:18
 */
public class MyThread2 extends Thread {

    private MyThread1 my1;

    public MyThread2(MyThread1 my1,String name){
        super(name);
        this.my1 = my1;
    }

    @Override
    public void run() {
        System.out.println("MyThread2开始");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }
        //确保MyThread2必须要在MyThread1结束之后才可以结束
        try {
            my1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread2结束");
    }
}
