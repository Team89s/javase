package com.igeek.javase.day18.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class FixedThreadPool {
    public static void main(String[] args) {
        //获得线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交任务
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());

        //关闭线程池
        executorService.shutdown();
    }

}
