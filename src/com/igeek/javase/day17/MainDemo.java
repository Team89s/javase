package com.igeek.javase.day17;

/**
 * @version 1.0
 * @Description 主线程
 * @Author chenmin
 * @Date 2020/11/30 10:33
 */
public class MainDemo {

    /**
     * 程序运行时，至少会有一条主线程
     *
     * 程序正常时，至少会一条主线程，会按照程序的执行顺序依次执行
     *
     * 程序出现运行期异常：除了主线程，还会有一条线程了控制异常信息的输出。此时，
     * 发生了多线程执行的情况，抢占"时间片"的使用权，执行出现的结果产生了随机性。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main开始执行");
        //空指针异常
        String str = null;
        System.out.println(str.length());
        System.out.println("main结束执行");
    }

}
