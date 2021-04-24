package com.igeek.javase.day02.game;

/**
 * @version 1.0
 * @Description 英雄类  继承角色类
 * @Author chenmin
 * @Date 2020/10/29 16:12
 */
public class Hero extends Role{

    //装备Equip（只能装3个装备，初始没有装备） 一对多的关联关系
    private Equip[] equips = new Equip[3];
    private int index = 0;

    public Hero() {
    }

    public Hero(String name, int level, int blood, int power, int defence, String kind) {
        super(name, level, blood, power, defence, kind);
    }

    /**
     * 基本攻击方法（拥有一定几率打出暴击）
     * @param role  要攻击的角色
     */
    @Override
    public void attack(Role role) {
        //暴击率
        int random = (int)(Math.random()*100+1);  //1~100
        int block = 0;
        if(random>=50){
            block = random*2;
        }

        //失血量 = 当前角色的攻击力 + 暴击率 - 被攻击角色的防御力
        int blood = this.getPower() + block - role.getDefence();

        //一旦攻击有效，设置被攻击角色的血量
        if(blood<=0){
            System.out.println("此回合攻击无效");
        }else{
            role.setBlood(role.getBlood() - blood);
            System.out.println("此回合攻击怪兽失去血量："+blood+"，怪兽剩余血量："+role.getBlood());
        }
    }

    /**
     * 添加装备的方法
     * @param e  装备
     */
    public void addEquip(Equip e){
        if(index<equips.length){
            equips[index++] = e;
            //设置攻击力
            this.setPower(this.getPower()+e.getPower());
            //设置防御力
            this.setDefence(this.getDefence()+e.getDefence());
        }
    }

    // 获取角色信息的方法show()
    @Override
    public void show() {
        super.show();
        System.out.println("------当前英雄拥有的装备信息------");
        for (Equip equip: equips) {
            if(equip!=null){
                equip.show();
            }
        }
    }
}
