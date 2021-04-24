package com.igeek.javase.day02.game;

/**
 * @version 1.0
 * @Description 怪兽类 继承了角色类
 * @Author chenmin
 * @Date 2020/10/29 16:12
 */
public class Monster extends Role{

    public Monster() {
    }

    public Monster(String name, int level, int blood, int power, int defence, String kind) {
        super(name, level, blood, power, defence, kind);
    }
}
