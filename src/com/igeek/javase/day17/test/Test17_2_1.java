package com.igeek.javase.day17.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0
 * @Description 作业卷第17天-关卡二-第1题
 * @Author chenmin
 * @Date 2020/12/8 11:22
 *
 * 请按如下要求编写多线程程序：
 * 			1.得到一个随机的整数n，创建n个子线程对象；
 * 			2.要求在子线程中把当前线程的名称作为元素添加一个集合中；
 * 			3.当n个线程的名称都添加到集合中，遍历集合打印每个线程的名称；
 */
public class Test17_2_1 {

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10)+1;  //1~10
        MyRunnable myRun = new MyRunnable(n);
        for (int i = 1; i <=n ; i++) {
            new Thread(myRun,"线程"+i).start();
        }
    }

}
class MyRunnable implements Runnable{
    private List<String> list = new ArrayList<>();
    private int n;

    public MyRunnable(int n){
        this.n = n;
    }

    @Override
    public void run() {
        synchronized (this){
            list.add(Thread.currentThread().getName());

            n--;
            if(n==0){
                //集合中元素添加完毕
                list.forEach(System.out::println);
            }
        }
    }
}
