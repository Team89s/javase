package com.igeek.javase.pattern.proxy.staticproxy;

//接口
public interface IBankService {

    boolean login(String name, String pwd);

    void register(String id, String name, String pwd);

}
