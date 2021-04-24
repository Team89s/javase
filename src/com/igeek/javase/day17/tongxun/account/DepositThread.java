package com.igeek.javase.day17.tongxun.account;

/**
 * @version 1.0
 * @Description 取款线程
 * @Author chenmin
 * @Date 2020/12/1 9:44
 */
public class DepositThread implements Runnable{

    private Account acc;

    public DepositThread(Account acc){
        this.acc = acc;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acc.deposit(10000);
        }
    }
}
