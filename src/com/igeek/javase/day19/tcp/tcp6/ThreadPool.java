package com.igeek.javase.day19.tcp.tcp6;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @Description 自定义一个线程池
 * @Author chenmin
 * @Date 2020/12/9 15:11
 *
 * 拒绝策略
 * 1.new ThreadPoolExecutor.AbortPolicy()  默认拒绝策略
 * 当任务添加到线程池中被拒绝时，抛出RejectedExecutionException异常
 * 2.new ThreadPoolExecutor.DiscardPolicy()
 * 当任务添加到线程池中被拒绝时，线程池将丢弃被拒绝的任务
 * 3.new ThreadPoolExecutor.DiscardOldestPolicy()
 * 当任务添加到线程池中被拒绝时，线程池会放弃等待队列中最旧的未处理任务，然后将拒绝的任务添加到等待队列中
 * 4.new ThreadPoolExecutor.CallerRunsPolicy()
 * 当任务添加到线程池中被拒绝时，会在线程池当前正在运行的Thread线程池中处理被拒绝的任务
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



