package com.igeek.javase.day17.method;

/**
 * @version 1.0
 * @Description 线程的方法 - sleep()或yield()
 * @Author chenmin
 * @Date 2020/11/30 15:02
 *
 * static void sleep(long millis) 当前正在执行的线程休眠（暂停执行）为指定的毫秒数，根据精度和系统定时器和调度的准确性。
 * 1.静态方法  Thread.sleep(1000);
 * 2.调用sleep()，线程会进入到阻塞状态   "真的退让"
 *              sleep()               睡眠时间结束
 *   运行状态   --------->  阻塞状态  ----------------->  可运行状态（继续争抢时间片）
 *
 * static void yield() 给调度程序的一个提示，当前线程愿意得到它当前的处理器的使用。
 * 1.静态方法  Thread.yield();
 * 2.将当前线程的时间片让度给优先级高的线程，会进入到可运行状态，拥有再次争抢时间片的机会  "假意退让"
 *               yield()
 *  运行状态   ----------> 可运行状态（继续争抢时间片）
 *
 * void join()  等待该线程死亡。
 * 1.非静态方法  t.join();
 * 2.调用join(),线程会进入到阻塞状态，直到等待线程结束
 *              join()                  等待线程结束
 *  运行状态   --------->  阻塞状态  ------------------>  可运行状态（继续争抢时间片）
 */
public class SleepDmo {

    public static void main(String[] args) {
        new Thread("线程t"){
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+" i = "+i);
                }
            }
        }.start();


        //主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
            //线程沉睡，会将时间片让出去
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {   //InterruptedException  中断异常
                e.printStackTrace();
            }*/

            //线程退让
            Thread.yield();
        }
    }

}
