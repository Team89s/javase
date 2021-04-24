package com.igeek.javase.day18.volatiles.atomic;

/**
 * @version 1.0
 * @Description 原子性 - 方式一：使用锁机制synchronized保证原子性
 * @Author chenmin
 * @Date 2020/12/3 11:23
 */
public class AtomicDemo2 {
    public static void main(String[] args) {
        MyRunnable2 my = new MyRunnable2();
        for (int i = 1; i <= 100; i++) {
            new Thread(my).start();
        }
    }
}

class MyRunnable2 implements Runnable{
    private int count; //0

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            synchronized (MyRunnable2.class){
                count++;  //读取主内存中的count，count+1，将工作内存的count写回到主内存
                System.out.println("count ====> "+count);
            }
        }
    }
}
