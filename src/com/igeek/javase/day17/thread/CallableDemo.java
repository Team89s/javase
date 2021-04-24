package com.igeek.javase.day17.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @version 1.0
 * @Description Callable
 * @Author chenmin
 * @Date 2020/11/30 11:02
 *
 * 创建线程的方式三 - 实现 implements Callable接口
 * 1.java.util.concurrent  简称为JUC
 * 2.Callable  提供一个方法 V call() throws Exception;
 * 返回一个结果，此时结果可能是执行任务返回的值，也有可能是抛出的异常
 *
 * 执行步骤：
 * 1.定义一个类实现Callable<T>接口
 * 2.重写call方法，返回值与泛型一致，定义执行的任务
 * 3.创建Callable带有返回的任务对象
 * 4.创建FutureTask（间接实现Runnable接口）任务对象，包装进Callable对象，返回Runnable对象
 * 5.创建Thread对象，放入任务对象
 * 6.启动线程 start()
 * 7.获得当前线程执行的结果
 *
 * 优点
 *      1.拓展性良好，实现Runnable接口，还可以再实现接口，再继承类
 *      2.同一个线程任务对象可以被包装成多个线程对象
 *      3.适合多个线程去共享同一个资源
 *      4.实现解耦操作，线程任务代码可以被多个线程共享，线程任务代码和线程独立
 *      5.线程池可以放入实现Runnable和Callable线程任务对象
 *      6.Callable中的call()是带有返回值的任务方法
 * 缺点：
 *      步骤过于繁琐
 */
public class CallableDemo {
    public static void main(String[] args) {
        //创建带有返回值的线程Callable任务对象
        MyCallable callable = new MyCallable();
        //创建FutureTask对象，传入Callable对象，将线程任务对象包装成异步任务对象
        FutureTask<String> task = new FutureTask<>(callable);
        //创建Runnable对象，传入异步任务FutureTask对象
        //Runnable myRun  = task;
        //创建线程对象
        Thread thread = new Thread(task,"线程1");
        //启动线程
        thread.start();

        //主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }

        //获取线程执行结果，让出CPU的执行权，确保能够获得线程对象执行结果
        try {
            String str = task.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
//自定义一个Callable的任务对象
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }
        return Thread.currentThread().getName()+"执行，产生结果："+sum;
    }
}
