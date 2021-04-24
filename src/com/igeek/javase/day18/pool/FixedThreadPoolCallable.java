package com.igeek.javase.day18.pool;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @Description 创建固定大小的线程池
 * @Author chenmin
 * @Date 2020/12/1 16:00
 *
 * newFixedThreadPool
 * 创建固定大小的线程池。
 * 每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，
 * 那么线程池会补充一个新线程。
 */
public class FixedThreadPoolCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //获得线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交异步任务
        Future<String> future1 = executorService.submit(new MyCallable());
        Future<String> future2 = executorService.submit(new MyCallable());
        Future<String> future3 = executorService.submit(new MyCallable());
        Future<String> future4 = executorService.submit(new MyCallable());
        Future<String> future5 = executorService.submit(new MyCallable());

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println(future4.get());
        System.out.println(future5.get());

        //关闭线程池
        executorService.shutdown();
    }

}
