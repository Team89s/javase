package com.igeek.javase.day10.list.cardgame;

import java.util.ArrayList;
import java.util.Collections;

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
 * 4.发牌
 *
 * 5.排序
 *
 * 6.看牌  打印输出
 */
public class CardGame {

    //单纯在存储牌信息的数据
    private static final ArrayList<Card> CARDS = new ArrayList<>();

    //定制这副牌（买好牌了）
    static{
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] nums = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};

        int index = 0;

        //先做出大王和小王牌
        CARDS.add(new Card("大王","",index++));
        CARDS.add(new Card("小王","",index++));

        //然后做 2♠ ~ 3♦
        for (String num : nums) {
            for (String color : colors) {
                CARDS.add(new Card(num,color,index++));
            }
        }

        //显示
        System.out.println(CARDS);
    }

    public static void main(String[] args) {
        //2.洗牌，打乱牌
        Collections.shuffle(CARDS);
        System.out.println(CARDS);

        //3.有三个牌搭子（牌友）  三个集合容器
        ArrayList<Card> play01 = new ArrayList<>();
        ArrayList<Card> play02 = new ArrayList<>();
        ArrayList<Card> play03 = new ArrayList<>();

        //4.发牌 0~53  012  345  678  9...  (0/3/6)%3==0  (1/4/7)%3==1  (2/5/8)%3==2
        //若当上地主，要有底牌，有3张底牌
        for (int i = 0; i < CARDS.size()-3; i++) {
            if(i%3==0){
                play01.add(CARDS.get(i));
            }else if(i%3==1){
                play02.add(CARDS.get(i));
            }else if(i%3==2){
                play03.add(CARDS.get(i));
            }
        }

        //5.排序
        Collections.sort(play01);
        Collections.sort(play02);
        Collections.sort(play03);

        //6.看牌  打印输出
        System.out.println("play01的牌:"+play01);
        System.out.println("play02的牌:"+play02);
        System.out.println("play03的牌:"+play03);
        System.out.println("底牌:"+CARDS.subList(CARDS.size()-3,CARDS.size()));
    }
}
