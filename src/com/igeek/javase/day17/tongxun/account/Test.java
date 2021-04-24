package com.igeek.javase.day17.tongxun.account;

/**
 * @version 1.0
 * @Description 线程通讯
 * @Author chenmin
 * @Date 2020/12/1 9:44
 */
public class Test {

    public static void main(String[] args) {
        //共同资源
        Account acc = new Account("002",10000);

        //创建了一条张三线程，进行访问共同资源的账户，完成取款操作
        new Thread(new WithdrawThread(acc),"张三").start();

        //创建了一条李四线程，进行访问共同资源的账户，完成取款操作
        new Thread(new WithdrawThread(acc),"李四").start();

        //创建了一条粑粑线程，进行访问共同资源的账户，完成存款操作
        new Thread(new DepositThread(acc),"粑粑").start();

        //创建了一条麻麻线程，进行访问共同资源的账户，完成存款操作
        new Thread(new DepositThread(acc),"麻麻").start();
    }

}
