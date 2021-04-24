package com.igeek.javase.day17.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 14:41
 *
 * 请按如下要求编写多线程程序：
 * 		1. 创建两个类，一个是测试类，一个是Thread的子类；
 * 		2. 在测试类中，创建两个Thread类的子类对象，将其中的一个线程对象的优先级
 * 		   设置10，另一个线程对象的优先级设置为6。
 * 		3. 让优先级为10的线程打印5次“线程1正在运行”，让优先级为6的线程打印
 * 		   10次“线程2正在运行”；
 * 		提示：
 * 1.设置线程优先级的方法为setPriority方法；
 * 2.得到线程优先级的方法为getPriority方法；
 */
public class Test17_3_2 {

    public static void main(String[] args) {
        MyThread my1 = new MyThread("线程1");
        my1.setPriority(10);
        MyThread my2 = new MyThread("线程2");
        my2.setPriority(6);
        my1.start();
        my2.start();
    }

}
class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        synchronized (MyThread.class) {
            if(Thread.currentThread().getPriority()==10){
                //让优先级为10的线程打印5次“线程1正在运行”
                for (int i = 1; i <=5 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"正在运行...");
                }
            }else if(Thread.currentThread().getPriority()==6){
                //让优先级为6的线程打印10次“线程2正在运行”；
                for (int i = 1; i <=10 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"正在运行...");
                }
            }
        }
    }
}
