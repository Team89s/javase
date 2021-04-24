package com.igeek.javase.day18.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Description 创建一个可缓存的线程池
 * @Author chenmin
 * @Date 2020/12/1 16:05
 *
 * newCachedThreadPool
 * 创建一个可缓存的线程池。
 * 如果线程池的大小超过了处理任务所需要的线程,
 * 那么会回收部分空闲（60秒不执行任务）的线程，当任务数增加时,
 * 此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，
 * 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService executorService = Executors.newCachedThreadPool();

        //提交任务
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());

        //关闭线程池
        executorService.shutdown();
    }

}
