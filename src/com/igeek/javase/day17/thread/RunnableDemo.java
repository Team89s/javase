package com.igeek.javase.day17.thread;

/**
 * @version 1.0
 * @Description Runnable 接口
 * @Author chenmin
 * @Date 2020/11/30 10:54
 *
 * 创建线程的方式二 - 实现  implements  Runnable接口
 * 1.自定义一个类实现Runnable接口
 * 2.重写run方法，run()定义执行的任务
 * 3.创建一个任务对象Runnable
 * 4.创建一个线程对象，将任务对象包装进去
 * 5.启动线程对象  start()
 *
 * 优点：
 *      1.拓展性良好，实现Runnable接口，还可以再实现接口，再继承类
 *      2.同一个线程任务对象可以被包装成多个线程对象
 *      3.适合多个线程去共享同一个资源
 *      4.实现解耦操作，线程任务代码可以被多个线程共享，线程任务代码和线程独立
 *      5.线程池可以放入实现Runnable和Callable线程任务对象
 * 缺点：
 *      相对于继承Thread要复杂点
 */
public class RunnableDemo {

    public static void main(String[] args) {
        //创建任务对象
        MyRunnable myRun = new MyRunnable();
        //创建线程对象，传入任务对象
        Thread my = new Thread(myRun,"线程2");
        //启动线程2
        my.start();

        //主线程
        myRun.run();
    }

}
//定义一个类实现Runnable接口
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" i = "+i);
        }
    }
}
