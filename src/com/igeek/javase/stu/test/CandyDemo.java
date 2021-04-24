package com.igeek.javase.stu.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/22 13:05
 * 有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
 *    每个小朋友都把自己的糖果分一半给左手边的孩子。
 *    一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
 *    反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
 *    你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
 *    例如：输入
 *    2 2 4
 *    程序应该输出：
 *    4
 *
 *       输入
 *    2 4 4 4
 *    程序应该输出：
 *    2
 */
public class CandyDemo {
     public static void getNum(int[] arr){
         int sum=0;  //补发糖果总数
         int[] half=new int[arr.length];  //存储每轮每个孩子糖果数的一半
         while(!isEqual(arr)){
             for (int i = 0; i < arr.length; i++) {
                 half[i]=arr[i]/2;
             }
             //单独处理最后一个孩子糖果数
             arr[arr.length-1]=half[arr.length-1]+half[0];
             for (int i = 0; i < arr.length-1; i++) {
                 arr[i]=half[i]+half[i+1];
             }
             //补发糖果
             for (int i = 0; i <arr.length ; i++) {
                 if(arr[i]%2==1){
                     arr[i]++;
                     sum++;
                 }
             }

         }
         System.out.println(sum);
     }
     public static boolean isEqual(int[] arr){
         for (int i = 0; i <arr.length-1 ; i++) {
             for (int j = i+1; j < arr.length; j++) {
                 if(arr[i]!=arr[j])
                     return false;
             }
         }
         return true;
     }

    public static void main(String[] args) {
        int[] arr={2,4,4,4};
        getNum(arr);
    }
}
