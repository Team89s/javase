package com.igeek.javase.pattern.proxy.cglib;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/17 10:34
 */
public class Test {

    public static void main(String[] args) {

        BankService target = new BankService();

        BankService proxy = new CglibLogProxyService(target).getProxy();
        System.out.println(proxy.login("lisi", "123"));
        proxy.register("003","张三","111");
    }

}
