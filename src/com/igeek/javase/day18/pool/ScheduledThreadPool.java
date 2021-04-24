package com.igeek.javase.day18.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description 创建一个大小无限的线程池
 * @Author chenmin
 * @Date 2020/12/1 16:09
 *
 * newScheduledThreadPool
 * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {

        //ScheduledExecutorService  在给定的延迟后运行或定期执行的命令的线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        /**
         * 第一个参数：Runnable 定期执行的任务
         * 第二个参数：initialDelay  首次执行任务的延迟时间
         * 第三个参数：period   执行任务的周期
         * 第四个参数：unit   前两个时间的单位
         */
        scheduledExecutorService.scheduleAtFixedRate(()->{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = sdf.format(new Date());
            System.out.println(str);
            System.out.println("-------------------------");
        },1000,1000, TimeUnit.MILLISECONDS);


        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str = sdf.format(new Date());
                System.out.println(str);
                System.out.println("-------------------------");
            }
        },0,1000);*/

    }

}
