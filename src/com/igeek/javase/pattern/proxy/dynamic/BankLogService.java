package com.igeek.javase.pattern.proxy.dynamic;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/17 9:19
 *
 * 在原本的银行的业务逻辑类中 新增需求：添加日志追踪
 *
 * 缺点：代码拓展性差，维护难度大
 */
public class BankLogService implements IBankService {

    @Override
    public boolean login(String name, String pwd) {
        boolean flag = false;
        System.out.println("the method login begin [ "+name+" , "+pwd+" ]");
        long beginTime = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if("lisi".equals(name) && "123".equals(pwd)){
            flag = true;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("login()耗时："+(endTime-beginTime)/1000.0+"s");
        return flag;
    }

    @Override
    public void register(String id, String name, String pwd) {
        System.out.println("the method register begin [ "+id+" , "+name+" , "+pwd+" ]");
        long beginTime = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("id="+id+",name="+name+",pwd="+pwd);
        long endTime = System.currentTimeMillis();
        System.out.println("register()耗时："+(endTime-beginTime)/1000.0+"s");
    }
}