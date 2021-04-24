package com.igeek.javase.day17.method;

/**
 * @version 1.0
 * @Description Priority 优先级
 * @Author chenmin
 * @Date 2020/11/30 14:37
 *
 * 优先级  1~10
 * MAX_PRIORITY  10
 * MIN_PRIORITY  1
 * NORM_PRIORITY 5  默认优先级
 * 结论：优先级越高，抢占到时间片的概率越高，但是能否真正去运行，还是要看是否抢占了时间片
 *
 * Thread.currentThread()  静态方法，获得当前正在执行的线程的状态信息
 * Thread[Thread-0,10,main]
 * Thread[线程的名称,优先级,线程组的名称]
 * 1.第一个值：线程的名称，若没有指定名字，则用默认的Thread-阿拉伯数字
 * 2.第二个值：优先级
 * 3.第三个值：当前线程所在的线程组，例如main线程组
 *
 * start()
 * 1.真正启动线程的方法
 * 2.group.add(this);  将当前线程对象添加至线程组中
 */
public class MyPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread()+" i = "+i);
            }
        });
        //设置线程的名称
        t1.setName("线程t");
        //调整线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        //启动线程，进入到"可运行状态"，争取到"时间片"，才会进入到"运行状态"
        t1.start();
        System.out.println("t1的优先级："+t1.getPriority());
    }
}
