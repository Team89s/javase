package com.igeek.javase.day17.tongxun;

/**
 * @version 1.0
 * @Description 消费者（线程）
 * @Author chenmin
 * @Date 2020/12/1 10:51
 */
public class Customer implements Runnable{

    private WareHouse house;

    public Customer(WareHouse house){
        this.house = house;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char c = house.pop();
        }
    }
}