package com.igeek.javase.day02.order;

/**
 * @version 1.0
 * @Description 商品类
 * @Author chenmin
 * @Date 2020/10/30 9:13
 */
public class Goods {

    private String name;
    private double price;
    private String detail;
    private int num;

    public Goods() {
    }

    public Goods(String name, double price, String detail, int num) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", num=" + num +
                '}';
    }
}
