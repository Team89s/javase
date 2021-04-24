package com.igeek.javase.day22.proxypattern.staticproxy;

/**
 * @version 1.0
 * @Description 静态代理
 * @Author chenmin
 * @Date 2020/12/17 11:02
 *
 * 静态代理
 * 代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法。
 *
 * 优点：在不修改目标对象的功能前提下, 能通过代理对象对目标功能扩展
 * 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类，
 * 一旦接口增加方法,目标对象与代理对象都要维护
 *
 */
public class BankLogProxyService implements IBankService {

    //关联：目标对象
    private IBankService target;

    public BankLogProxyService(IBankService target){
        this.target = target;
    }

    @Override
    public boolean login(String name, String pwd) {
        System.out.println("the method login [ "+name+" , "+pwd+" ]");
        long begin = System.currentTimeMillis();
        //执行目标方法
        boolean flag = target.login(name, pwd);
        long end = System.currentTimeMillis();
        System.out.println("login()耗时："+(end-begin)/1000.0+"s");
        return flag;
    }

    @Override
    public void register(String id, String name, String pwd) {
        System.out.println("the method register [ "+name+" , "+pwd+" ]");
        long begin = System.currentTimeMillis();
        target.register(id,name, pwd);
        long end = System.currentTimeMillis();
        System.out.println("register()耗时："+(end-begin)/1000.0+"s");
    }
}
