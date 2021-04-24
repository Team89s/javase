package com.igeek.javase.day18.juc;

/**
 * @version 1.0
 * @Description 线程安全的单例
 * @Author chenmin
 * @Date 2020/12/4 16:47
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){

    }

    //DCL  double checked lock  双重锁
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    /**
                     *  singleton = new Singleton();  并不能够保证原子性
                     */
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
