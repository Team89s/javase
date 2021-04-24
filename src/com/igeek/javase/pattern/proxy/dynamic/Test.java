package com.igeek.javase.pattern.proxy.dynamic;

/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/12/17 9:23
 */
public class Test {

    public static void main(String[] args) {
        //未做代理模式之前的测试
        /*IBankService bank = new BankLogService();
        System.out.println(bank.login("lisi", "123"));
        bank.register("001","张三","123456");*/

        //JDK动态代理
        //目标对象
        IBankService target = new BankService();
        //代理对象
        IBankService proxy = new BankLogProxyService<IBankService>(target).getProxy();
        System.out.println(proxy.login("lisi","123"));
        proxy.register("002","张三","111");
    }

}
