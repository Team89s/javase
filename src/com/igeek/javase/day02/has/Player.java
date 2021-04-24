package com.igeek.javase.day02.has;

/**
 * @version 1.0
 * @Description 关联关系体现之一：强关联（组合关系）和弱关联（聚合关系）
 * @Author chenmin
 * @Date 2020/11/3 14:30
 *
 * 强关联（组合关系）：随着对象创建而创建，随着对象销毁而销毁
 * 弱关联（聚合关系）：不会随着对象的创建而创建，不会随着对象销毁而销毁
 */
class Team {
    private Player player;

    //强关联（组合关系）
    public Team(){
        player = new Player();
    }

    public void work(){
        player.play();
    }

    //弱关联（聚合关系）
    /*public Team(Player player){
        this.player = player;
    }*/
}
public class Player{
    private String name;
    private String sex;

    public void play(){
        System.out.println(name+"正在运动...");
    }
}