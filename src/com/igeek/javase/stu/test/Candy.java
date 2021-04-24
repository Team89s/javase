package com.igeek.javase.stu.test;
//老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
// * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
// * 1.每个孩子至少分配到 1个糖果。
// * 2.相邻的孩子中，评分高的孩子必须获得更多的糖果。
// *   那么这样下来，老师至少需要准备多少颗糖果呢？

import java.util.Arrays;

/**
 * @version 1.0
 * @Description TODO
 * @Author zhouyuji周遇吉
 * @Date 2020/11/26 9:00
 */
public class Candy {
    public static int candy(int[] rank) {
        int[] candies = new int[rank.length];
        //每个人分一个糖果
        Arrays.fill ( candies, 1 );


        int sum = 0;

        for (int i = 0; i < rank.length; i++) {
             //如果一个人比前一个人分数高，且糖果小于或者等于前一个人，则他多拿一个糖果
            if (i > 0 && rank[i] > rank[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
            //如果这个人比后一个人分数高，且糖果小于或者等于后一个人，则他多拿一个糖果
            if (i < rank.length - 1 && rank[i] > rank[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        for (int candy : candies) {
            sum += candy;
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 7};
        System.out.println ( candy ( arr ) );

    }

}
