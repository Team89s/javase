package com.igeek.javase.day22.proxypattern.cglib;

/**
 * @version 1.0
 * @Description BankService  业务逻辑类
 * @Author chenmin
 * @Date 2020/12/17 9:17
 */
public /*final*/ class BankService{

    /*public BankService(int a){

    }*/

    public /*final*/ /*static*/ boolean login(String name, String pwd) {
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

    public void register(String id, String name, String pwd) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("id="+id+",name="+name+",pwd="+pwd);
    }
}
