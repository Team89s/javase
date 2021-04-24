package com.igeek.javase.day18.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Description 创建一个单线程的线程池
 * @Author chenmin
 * @Date 2020/12/1 15:56
 *
 * newSingleThreadExecutor
 * 创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
 * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 */
public class SingleThreadPool {

    public static void main(String[] args) {

        //Executors是一个执行线程的工具类
        //ExecutorService是真正的线程池接口
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //提交任务
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());

        //关闭线程池
        executorService.shutdown();
    }

}
