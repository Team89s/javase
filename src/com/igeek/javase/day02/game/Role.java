package com.igeek.javase.day02.game;

/**
 * @version 1.0
 * @Description 角色类 - 父类
 * @Author chenmin
 * @Date 2020/10/29 16:12
 */
public class Role {
    //昵称name
    private String name;
    //等级level
    private int level;
    //血量blood
    private int blood;
    //攻击力power
    private int power;
    //防御力defence
    private int defence;
    //种族kind
    private String kind;

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

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Role() {
    }

    public Role(String name, int level, int blood, int power, int defence, String kind) {
        this.name = name;
        this.level = level;
        this.blood = blood;
        this.power = power;
        this.defence = defence;
        this.kind = kind;
    }

    /**
     * 基本攻击方法
     * @param role  要攻击的角色
     */
    public void attack(Role role){
        //失血量 = 当前角色的攻击力 - 攻击的角色的防御力
        int blood = this.power - role.defence;

        //一旦攻击有效，设置剩余血量
        if(blood<=0){
            System.out.println("此回合攻击无效");
        }else{
            //攻击有效
            role.blood = role.blood - blood;
            System.out.println("此回合攻击英雄失去血量："+blood+"，英雄剩余血量："+role.blood);
        }
    }

    /**
     * 死亡判定方法
     * @return true代表角色死亡  false代表角色存活
     */
    public boolean isDead(){
        if(this.blood<=0){
            return true; //代表角色死亡
        }
        return false; //代表角色存活
    }

    //获取角色信息的方法show()
    public void show(){
        System.out.println("昵称："+name);
        System.out.println("等级："+level);
        System.out.println("血量："+blood);
        System.out.println("攻击力："+power);
        System.out.println("防御力："+defence);
        System.out.println("种族："+kind);
    }
}
