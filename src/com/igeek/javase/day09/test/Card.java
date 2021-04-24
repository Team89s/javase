package com.igeek.javase.day09.test;

/**
 * @version 1.0
 * @Description 纸牌类
 * @Author chenmin
 * @Date 2020/11/12 15:51
 *
 * 游戏规则：
 * 1.假设先定制一副新牌54张
 *  牌面数字：大王 小王  "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"
 *  牌面花色："♠", "♥", "♣", "♦"
 *  牌面类似于：3♠  4♥  K♣  A♦  大王  小王
 *
 * 2.洗牌，打乱牌
 *
 * 3.有三个牌搭子（牌友）  三个集合容器
 *
 * 4.发牌：哪个玩家拿到大王,就需要拿底牌
 *
 * 5.排序
 *
 * 6.看牌  打印输出
 */
public class Card implements Comparable<Card>{

    private String num;
    private String color;
    private int index;

    public Card() {
    }

    public Card(String num, String color, int index) {
        this.num = num;
        this.color = color;
        this.index = index;
    }

    /**
     * 获取
     * @return num
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * 设置
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    public String toString() {
        return num+color;
    }

    @Override
    public int compareTo(Card o) {
        return this.index-o.index;
    }
}
