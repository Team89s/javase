package com.igeek.javase.day21.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/22 20:01
 */
public class Calculator implements ICalculator{

    public int add(int a,int b){
        int c = a+b;
        return c;
    }

    public int sub(int a,int b){
        int c = a-b;
        return c;
    }

    public int mul(int a,int b){
        int c = a*b;
        return c;
    }

    public int div(int a,int b){
        int c = a/b;
        return c;
    }

}
