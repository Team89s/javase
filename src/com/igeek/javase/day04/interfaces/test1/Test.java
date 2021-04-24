package com.igeek.javase.day04.interfaces.test1;

/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/11/2 15:06
 */
public class Test {

    public void makeFly(CanFly canFly){
        canFly.fly();
    }

    public static void main(String[] args) {
        Test test = new Test();

        CanFly airplane = new Airplane();
        test.makeFly(airplane);
    }

}
