package com.igeek.javase.day21.reflect.singleton;

/**
 * @version 1.0
 * @Description 懒汉式-线程安全的单例模式
 * @Author chenmin
 * @Date 2020/12/16 10:26
 */
public class Singleton1 {

    private static volatile Singleton1 singleton;

    private Singleton1(){
        System.out.println(Thread.currentThread().getName());
    }

    public static Singleton1 getInstance(){
        if(singleton==null){
            synchronized(Singleton1.class){
                if(singleton==null){
                    singleton = new Singleton1();
                    /**
                     * 指令重排：
                     * 1.分配内存空间
                     * 2.调用构造方法，创建实例
                     * 3.将对象指向内存空间
                     *
                     * 期望123顺序
                     * 指令重排132顺序，先分配内存空间，直接将对象指向内存空间
                     *
                     * 解决方案：添加内存屏障  volatile 可见性、不能保证原子性、重排性
                     * volatile关键字通过“内存屏障”来防止指令被重排序
                     */
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> Singleton1.getInstance()).start();
        }
    }
}
