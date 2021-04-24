package com.igeek.javase.day18.volatiles.barrier;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Description 指令重排 - 解决方案：内存屏障
 * @Author chenmin
 * @Date 2020/12/4 9:42
 *
 * 解决方式：volatile关键字通过“内存屏障”来防止指令被重排序
 */
public class BarrierDemo {

    volatile int a = 0;
    volatile int b = 0;
    volatile int x = 0;
    volatile int y = 0;

    //创建单个线程的线程池
    private static ExecutorService pool1= Executors.newSingleThreadExecutor();
    private static ExecutorService pool2= Executors.newSingleThreadExecutor();
    private static ExecutorService pool3= Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("abc.txt");

        for (int i=0;i< 10000;i++){
            //初始化
            BarrierDemo barrier=new BarrierDemo();

            //处理器A执行
            pool1.submit(()->{
                barrier.a = 1; //A1
                barrier.x = barrier.b; //A2
                print(barrier,pw);
            });

            //处理器B执行
            pool2.submit(()->{
                barrier.b = 2; //B1
                barrier.y = barrier.a; //B2
                print(barrier,pw);
            });
        }
    }

    private static void print(BarrierDemo barrier,PrintWriter pw){
        pool3.submit(()->{
            if(barrier.x==0 && barrier.y==0){
                pw.println("=======>"+barrier.a+" , "+barrier.b+" , "+barrier.x+" , "+barrier.y);
            }/*else {
                pw.println(barrier.a+" , "+barrier.b+" , "+barrier.x+" , "+barrier.y);
            }*/
        });
    }

}
