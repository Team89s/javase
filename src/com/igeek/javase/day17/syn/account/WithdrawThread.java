package com.igeek.javase.day17.syn.account;

/**
 * @version 1.0
 * @Description 取款线程
 * @Author chenmin
 * @Date 2020/12/1 9:44
 */
public class WithdrawThread implements Runnable{

    private Account acc;

    public WithdrawThread(Account acc){
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.withdraw(10000);
    }
}
