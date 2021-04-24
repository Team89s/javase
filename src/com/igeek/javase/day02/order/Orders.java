package com.igeek.javase.day02.order;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description 订单类
 * @Author chenmin
 * @Date 2020/10/30 9:13
 */
public class Orders {

    private long id;

    //一对一关联
    private User user;
    //一对多关联
    private Goods[] goods;

    public Orders() {
    }

    public Orders(long id, User user, Goods[] goods) {
        this.id = id;
        this.user = user;
        this.goods = goods;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods[] getGoods() {
        return goods;
    }

    public void setGoods(Goods[] goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", goods=" + Arrays.toString(goods) +
                '}';
    }

    //展示订单明细
    public void showDetail(){
        System.out.println("-------"+this.id+"号订单明细--------");
        for (Goods good:goods) {
            System.out.println(good);
        }
    }
}
