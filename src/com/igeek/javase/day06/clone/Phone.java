package com.igeek.javase.day06.clone;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/4 10:22
 */
public class Phone implements Cloneable {

    private String label;
    private double price;

    public Phone() {
    }

    public Phone(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "label='" + label + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    protected Phone clone() throws CloneNotSupportedException {
        return (Phone)super.clone();
    }
}
