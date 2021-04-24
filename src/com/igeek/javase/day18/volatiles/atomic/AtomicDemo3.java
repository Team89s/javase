package com.igeek.javase.day18.volatiles.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Description 原子性 - 方式二：JUC包下的原子类
 * @Author chenmin
 * @Date 2020/12/3 15:18
 *
 * 原子类依据的原理CAS  Compare And Swap  比较再交换
 */
public class AtomicDemo3 {

    public static void main(String[] args) {
        MyRunnable3 my = new MyRunnable3();
        for (int i = 1; i <= 100; i++) {
            new Thread(my).start();
        }
    }

}
class MyRunnable3 implements Runnable{
    //原子类
    private AtomicInteger atomicInteger = new AtomicInteger();  //0

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            int count = atomicInteger.incrementAndGet(); //等价于++count
            System.out.println("count ====> "+count);
        }
    }
}