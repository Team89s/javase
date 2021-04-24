package com.igeek.javase.day17.thread.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @version 1.0
 * @Description  简化版本 - Callable
 * @Author chenmin
 * @Date 2020/11/30 11:02
 *
 */
public class CallableDemo {
    public static void main(String[] args) {

        new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum+=i;
                    System.out.println(Thread.currentThread().getName()+" i = "+i);
                }
                return Thread.currentThread().getName()+"执行结果："+sum;
            }
        }),"线程1").start();


        FutureTask<String> task = new FutureTask<>(()->{
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum+=i;
                System.out.println(Thread.currentThread().getName()+" i = "+i);
            }
            return Thread.currentThread().getName()+"执行结果："+sum;
        });
        new Thread(task,"线程2").start();
        try {
            //获得执行结果
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        new Thread(new FutureTask<String>(() ->{
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum+=i;
                System.out.println(Thread.currentThread().getName()+" i = "+i);
            }
            return Thread.currentThread().getName()+"执行结果："+sum;
        }),"线程3").start();


        //主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }
    }
}