package com.igeek.javase.day15.recursion;

/**
 * @version 1.0
 * @Description 递归
 * @Author chenmin
 * @Date 2020/11/24 11:13
 *
 * 非规律性
 *    喝啤酒问题，一瓶啤酒2元，两个空瓶子可以换一瓶啤酒，四个啤酒盖可以换一瓶啤酒，请问10元一共可以喝多少瓶？
 */
public class RecursionTest2 {

    //购买啤酒的总数量
    private static int totalNum;
    //剩余瓶子数量
    private static int lastBottle;
    //剩余瓶盖数量
    private static int lastCap;

    /**
     * 购买啤酒的方法
     * @param money 花的钱
     */
    public static void buy(int money){  //10   6   6   2   4
        //已购买的啤酒数量
        int num = money/2;  //5  3   3   1  2

        //购买啤酒的总数量
        totalNum+=num;  //5  8  11  12  14 5

        //当前牌瓶子数量
        int nowBottle = lastBottle + num;  //5 1+3  0+3 1+1
        //当前牌盖子数量
        int nowCap = lastCap + num;  //5 1+3  0+3  3+1

        int newMoney = 0;  //6  6
        //将瓶子和盖子兑换钱
        newMoney += (nowBottle/2)*2; //4  4  2  2
        newMoney += (nowCap/4)*2;  //2  2  0   2

        //每一轮兑换完毕的剩余瓶子和盖子的数量
        lastBottle = nowBottle%2; //1  0  1  0
        lastCap = nowCap%4; //1  0  3  0

        if(newMoney>=2){
            buy(newMoney);
        }
    }

    public static void main(String[] args) {
        buy(10);
        System.out.println("购买啤酒的总数量:"+totalNum);  //15
        System.out.println("剩余瓶子数量:"+lastBottle);  //1
        System.out.println("剩余瓶盖数量:"+lastCap);  //3
    }


}
