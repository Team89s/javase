package com.igeek.javase.pattern.singleton;

/**
 * @version 1.0
 * @Description 线程安全的单例
 * @Author chenmin
 * @Date 2020/12/4 16:47
 */
public class SingletonDemo4 {

    private volatile static SingletonDemo4 singleton;

    private SingletonDemo4(){

    }

    //DCL  double checked lock  双重锁
    public static SingletonDemo4 getInstance(){
        if(singleton==null){
            synchronized (SingletonDemo4.class){
                if(singleton==null){
                    /**
                     *  singleton = new Singleton();  并不能够保证原子性
                     */
                    singleton = new SingletonDemo4();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonDemo4 instance1 = SingletonDemo4.getInstance();
        SingletonDemo4 instance2 = SingletonDemo4.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        //通过反射获取实例，判断对象是否与反射获取的实例是相同的  false
    }
}
