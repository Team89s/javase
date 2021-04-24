package com.igeek.javase.day17.syn.account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Description 账户类
 * @Author chenmin
 * @Date 2020/12/1 9:40
 */
public class Account {

    private String id;
    private int balance;

    private final Lock lock = new ReentrantLock();

    /**
     * 取款方法
     * @param money  取的金额
     * @return  账户信息
     */
    public /*synchronized*/ Account withdraw(int money){
        String name = Thread.currentThread().getName();
        //上锁
        lock.lock();

        //synchronized (this){
        try {
            if(balance>=money){
                System.out.println(name+"正在取钱，余额充足，取出"+money);
                balance-=money;
                System.out.println("当前账户剩余"+balance);
            }else{
                System.out.println(name+"正在取钱，余额不足");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            lock.unlock();
        }

        //}

        return this;
    }


    public Account() {
    }

    public Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account{id = " + id + ", balance = " + balance + "}";
    }
}
