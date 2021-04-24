package com.igeek.javase.day18.volatiles.atomic;

/**
 * @version 1.0
 * @Description 原子性
 * @Author chenmin
 * @Date 2020/12/3 11:23
 */
public class AtomicDemo1 {
    public static void main(String[] args) {
        MyRunnable1 my = new MyRunnable1();
        for (int i = 1; i <= 100; i++) {
            new Thread(my).start();
        }
    }
}
class MyRunnable1 implements Runnable{
    //volatile  不具备原子性
    private volatile int count; //0

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            count++;
            System.out.println("count ====> "+count);
        }
    }
}
