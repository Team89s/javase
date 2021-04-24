package com.igeek.javase.day02.has;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/29 14:00
 */
public class Phone {

    private String label;
    private double price;
    private String color;

    public Phone() {
    }

    public Phone(String label, double price, String color) {
        this.label = label;
        this.price = price;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "label='" + label + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
