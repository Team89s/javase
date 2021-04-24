package com.igeek.javase.day21.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/22 20:03
 */
public class Test13 {

    public static void main(String[] args) {

        ICalculator target = new Calculator();

        ICalculator proxy = new CalculatorProxy(target).getProxy();
        System.out.println(proxy.getClass().getName());  //com.sun.proxy.$Proxy0

        int result1 = proxy.add(1, 10);
        System.out.println("result1 = "+result1);

        int result2 = proxy.div(10, 10);
        System.out.println("result2 = "+result2);
    }

}
