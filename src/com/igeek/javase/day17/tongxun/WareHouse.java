package com.igeek.javase.day17.tongxun;

/**
 * @version 1.0
 * @Description 仓库（共同资源）
 * @Author chenmin
 * @Date 2020/12/1 10:51
 *
 * 线程通讯：生产者和消费者
 *
 * 1.线程通讯是一种等待唤醒机制
 * 2.线程通讯一定是多个线程在操作同一个资源才需要进行通信
 * 3.线程通信必须先保证线程安全，否则毫无意义，代码也会报错 java.lang.IllegalMonitorStateException
 * 4.线程同步使用的对象锁必须保证唯一
 * 5.只有锁对象才能调用notify()和wait()方法
 */
public class WareHouse {

    private char[] chs = new char[5];
    private int index;

    //生产（入栈）
    public synchronized void push(char c){
        if(index>=chs.length){
            System.out.println("仓库已满...");
            try {
                //生产者进入等待状态
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chs[index++] = c;
        System.out.println("仓库添加元素 "+c+" 了，可以消费了....");
        //一旦生产者进行生产了，通知消费者你可以消费了
        this.notify();
    }


    //消费（出栈）
    public synchronized char pop(){
        if(index==0){
            System.out.println("仓库已空");
            try {
                //消费者等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        char c = chs[--index];
        System.out.println("仓库消费元素 "+c+" 了，可以生产了....");
        //通知生产者可以进行生产了
        this.notify();
        return c;
    }

}
