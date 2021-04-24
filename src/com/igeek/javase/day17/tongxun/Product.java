package com.igeek.javase.day17.tongxun;

/**
 * @version 1.0
 * @Description 生产者（线程）
 * @Author chenmin
 * @Date 2020/12/1 10:51
 */
public class Product implements Runnable{

    private WareHouse house;

    public Product(WareHouse house){
        this.house = house;
    }

    @Override
    public void run() {
        //死循环
        for (int i = 0; ;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char c = (char)('A'+i);
            house.push(c);
        }
    }
}
