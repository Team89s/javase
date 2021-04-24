package com.igeek.javase.day01.visible.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/28 9:40
 */
public class ScoreTest {

    public static void main(String[] args) {

        //无参构造方法
        Score score1 = new Score();
        score1.setJavaScore(95.5F);
        score1.setCsharpScore(65.0F);
        score1.setOracleScore(76.5F);
        System.out.println("成绩之和："+ score1.getSum());
        System.out.println("成绩平均分："+ score1.getAvg());

        //有参构造方法
        Score score2 = new Score(80.0F,90.0F,100.0F);
        System.out.println("成绩之和："+ score2.getSum());
        System.out.println("成绩平均分："+ score2.getAvg());
    }

}
