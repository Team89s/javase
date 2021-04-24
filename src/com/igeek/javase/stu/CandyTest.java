package com.igeek.javase.stu;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description 算法题分享
 * @Author 徐超
 * @Date 2020/11/24 13:38
 *
 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 1.每个孩子至少分配到 1个糖果。
 * 2.相邻的孩子中，评分高的孩子必须获得更多的糖果。
 *   那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class CandyTest {
    public static int candy(int[] rank){
        int[] candies = new int[rank.length];
        Arrays.fill(candies,1);

        boolean flag =true;
        int sum =0;


       while (flag){

           for (int i = 0; i < rank.length; i++) {
               flag = false;

               if(i>0 && rank[i]>rank[i-1] && candies[i]<=candies[i-1]){
                   candies[i] = candies[i-1]+1;
                  flag = true;
               }

               if(i<rank.length-1 && rank[i]>rank[i+1] && candies[i]<=candies[i+1]){
                   candies[i] = candies[i+1]+1;
                   flag = true;
               }


           }
       }

        for (int candy : candies) {
            sum+=candy;
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,3,2};
        System.out.println(candy(arr));

    }

}
