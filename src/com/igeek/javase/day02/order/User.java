package com.igeek.javase.day02.order;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description 用户类
 * @Author chenmin
 * @Date 2020/10/30 9:13
 */
public class User {

    private String username;
    private String address;
    private String phoneNum;

    //一对多关联订单
    private Orders[] orders;

    public User() {
    }

    public User(String username, String address, String phoneNum) {
        this.username = username;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Orders[] getOrders() {
        return orders;
    }

    public void setOrders(Orders[] orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", orders=" + Arrays.toString(orders) +
                '}';
    }

    //用户下单方法
    public void xiadan(){
        System.out.println("用户名："+this.username);
        System.out.println("--------"+this.username+"的订单---------");
        for (Orders order:orders) {
            order.showDetail();
        }

        //java.lang.StackOverflowError  堆栈溢出
        /*System.out.println("用户："+this);
        for (Orders order:orders) {
            System.out.println(order);
        }*/
    }
}
