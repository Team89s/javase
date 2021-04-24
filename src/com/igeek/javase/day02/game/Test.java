package com.igeek.javase.day02.game;

/**
 * @version 1.0
 * @Description 回合制攻击测试
 * @Author chenmin
 * @Date 2020/10/29 16:12
 */
public class Test {

    public static void main(String[] args) {

        Monster monster = new Monster("哥斯拉",66,800,200,220,"怪兽");
        Hero hero = new Hero("剑圣",99,1200,230,120,"兽类");

        Equip equip1 = new Equip("短刀",10,"银色","刀具",50,10);
        Equip equip2 = new Equip("长剑",10,"金色","剑类",30,30);
        Equip equip3 = new Equip("斧头",10,"银色","斧头类",30,50);
        Equip equip4 = new Equip("盾牌",10,"金色","盾牌类",10,60);
        hero.addEquip(equip1);
        //hero.addEquip(equip2);
        //hero.addEquip(equip3);
        //hero.addEquip(equip4);

        //monster.show();
        //hero.show();

        //产生回合制攻击
        int count = 0;
        while(true){
            count++;
            System.out.println("--------当前第"+count+"回合--------");

            //英雄先打怪兽
            hero.attack(monster);
            if (monster.isDead()){
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //怪兽再打英雄
            monster.attack(hero);
            if(hero.isDead()){
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
