package com.igeek.javase.day19.tcp.tcp7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description 自定义一个线程池
 * @Author chenmin
 * @Date 2020/12/9 15:11
 *
 */
public class ThreadPool {

    //线程池对象
    private ExecutorService pool;

    /**
     * 创建自定义的线程池的构造方法
     * @param maxPoolSize  线程池中允许的最大线程数量
     * @param queueSize    阻塞任务队列中，允许等待的任务数量
     */
    public ThreadPool(int maxPoolSize,int queueSize){
        pool = new ThreadPoolExecutor(
                3,  //线程池中核心的线程数
                maxPoolSize,    //线程池中允许的最大线程数量
                60L, //线程池中超过corePoolSize大小后，多余的空闲线程等待新任务的最长时间
                TimeUnit.SECONDS,  //keepAliveTime参数的时间单位
                new ArrayBlockingQueue<Runnable>(queueSize),  //阻塞任务队列对象
                new ThreadPoolExecutor.AbortPolicy()  //拒绝策略
        );
    }

    //执行任务的方法
    public void execute(Runnable task){
        pool.execute(task);
    }
}



