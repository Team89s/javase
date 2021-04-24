package com.igeek.javase.day22.proxypattern.staticproxy;

/**
 * @version 1.0
 * @Description BankService  业务逻辑类
 * @Author chenmin
 * @Date 2020/12/17 9:17
 */
public class BankService implements IBankService{

    @Override
    public boolean login(String name, String pwd) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if("lisi".equals(name) && "123".equals(pwd)){
            return true;
        }
        return false;
    }

    @Override
    public void register(String id, String name, String pwd) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("id="+id+",name="+name+",pwd="+pwd);
    }
}
