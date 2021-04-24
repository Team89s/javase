package com.igeek.javase.day02.game;

/**
 * @version 1.0
 * @Description 装备类
 * @Author chenmin
 * @Date 2020/10/29 16:12
 */
public class Equip {
    //名称name
    private String name;
    //级别level
    private int level;
    //颜色color
    private String color;
    //类别kind
    private String kind;
    //攻击力power
    private int power;
    //防御力defence
    private int defence;

    //构造器
    public Equip() {
    }

    public Equip(String name, int level, String color, String kind, int power, int defence) {
        this.name = name;
        this.level = level;
        this.color = color;
        this.kind = kind;
        this.power = power;
        this.defence = defence;
    }

    //getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    //装备拥有获取装备信息的方法show()
    public void show(){
        System.out.println("装备名称："+name);
        System.out.println("装备级别："+level);
        System.out.println("装备颜色："+color);
        System.out.println("装备种类："+kind);
        System.out.println("装备攻击力："+power);
        System.out.println("装备防御力："+defence);
    }
}
