package com.igeek.javase.day17.tongxun.account;

/**
 * @version 1.0
 * @Description 账户类
 * @Author chenmin
 * @Date 2020/12/1 9:40
 */
public class Account {

    private String id;
    private int balance;

    /**
     * 取款方法
     * @param money  取的金额
     * @return  账户信息
     */
    public synchronized Account withdraw(int money){
        String name = Thread.currentThread().getName();

        if(balance>=money){
            balance-=money;
            System.out.println(name+"正在取钱，余额充足，取出"+money+"，当前账户剩余"+balance);
            //取钱完毕，唤醒其他（存款）线程，可以进行存钱
            this.notifyAll();
            //当前自己的线程，进入等待状态
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(name+"正在取钱，余额不足");
            //唤醒其他（存款）线程，可以进行存钱
            this.notifyAll();
            //当前自己的线程，进入等待状态
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }


    /**
     * 存款方法
     * @param money  存的金额
     * @return  账户信息
     */
    public synchronized Account deposit(int money){
        String name = Thread.currentThread().getName();

        if(balance>0){
            System.out.println(name+"正在存钱，但是当前账户有余额");
            //唤醒其他（取钱的）线程，进行取钱操作
            this.notifyAll();
            //本线程进入等待状态
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            balance+=money;
            System.out.println(name+"正在存钱，存进"+money+"，当前账户剩余"+balance);
            //唤醒其他（取钱的）线程，进行取钱操作
            this.notifyAll();
            //本线程进入等待状态
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
