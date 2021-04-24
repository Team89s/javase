package com.igeek.javase.day04.interfaces.test1;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/2 15:06
 */
public class Airplane implements CanFly {
    @Override
    public void fly() {
        System.out.println("飞机起飞...");
    }
}
