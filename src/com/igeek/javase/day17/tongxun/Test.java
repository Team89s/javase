package com.igeek.javase.day17.tongxun;

/**
 * @version 1.0
 * @Description 线程通讯的测试类
 * @Author chenmin
 * @Date 2020/12/1 10:52
 */
public class Test {

    public static void main(String[] args) {

        WareHouse house = new WareHouse();

        //生产者
        new Thread(new Product(house)).start();
        //消费者
        new Thread(new Customer(house)).start();
    }

}
