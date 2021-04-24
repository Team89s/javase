package com.igeek.javase.day22.proxypattern.staticproxy;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/17 11:06
 */
public class Test {

    public static void main(String[] args) {

        IBankService target = new BankService();
        BankLogProxyService proxy = new BankLogProxyService(target);
        System.out.println(proxy.login("lisi", "123"));

    }

}
