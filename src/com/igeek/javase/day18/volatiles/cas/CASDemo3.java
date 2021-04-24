package com.igeek.javase.day18.volatiles.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @version 1.0
 * @Description CAS  Compare And Swap
 * @Author chenmin
 * @Date 2020/12/3 16:14
 *
 * CAS原理：比较当前工作内存中的值和主内存中的值，如果这个值是期望的，那么则执行操作，如果不是就一直循环。
 * 缺点：
 * 1.循环会耗时
 * 2.一次性只能保证一个共享变量的原子性
 * 3.会出现ABA问题（此时建议引入原子引用，使用带版本号的原子操作，例如：AtomicStampedReference中的getStamp()方法）
 *
 * CAS 中存在ABA问题
 * 解决方案：AtomicStampedReference
 */
public class CASDemo3 {

    //构造方法中，第一个参数initialRef - 初始引用；第二个参数initialStamp - 初始标志
    static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(10,1);

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("a1 ---> "+reference.getStamp());  //1

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * compareAndSet()
             * 第一个参数：期望值
             * 第二个参数：更新值
             * 第三个参数：期望标志
             * 第四个参数：更新标志
             *
             * 返回值 true代表交换成功，false交换失败
             */
            System.out.println(reference.compareAndSet(10, 11,
                    reference.getStamp(), reference.getStamp() + 1)); //true  值：11  stamp:2
            System.out.println("a2 ---> "+reference.getStamp());  //2

            System.out.println(reference.compareAndSet(11, 10,
                    reference.getStamp(), reference.getStamp() + 1)); //true 值：10  stamp:3
            System.out.println("a3 ---> "+reference.getStamp()); //3

        },"线程A").start();


        new Thread(()->{
            //标志
            int stamp = reference.getStamp();
            System.out.println("b1 ---> "+stamp);   //1

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(reference.compareAndSet(10, 66,
                    stamp, stamp + 1));  //false

            System.out.println("b2 ---> "+reference.getStamp());  //3

        },"线程B").start();
    }

}
