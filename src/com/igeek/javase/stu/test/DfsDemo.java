package com.igeek.javase.stu.test;

import java.util.Scanner;

/**
 * @Description 马在中国象棋以日字形规则移动。
 *  * 请编写一段程序，给定n*m大小的棋盘，以及马的初始位置(x，y)，
 *  * 要求不能重复经过棋盘上的同一个点，计算马可以有多少途径遍历棋盘上的所有点
 * @Author fuxiaohai  傅晓海
 * @Date 2020/12/3 0003 20:14
 */
public class DfsDemo {
    //棋盘的点数
    private static int point;
    //定义棋盘大小，m行，n列
    private static int m;
    private static int n;
    //定义棋盘可以走的路径数目
    private static int path;
    //定义一个数组来表示棋盘
    private static int[][] board;

    //定义马能跳的8个方向
    private static int[][] dir ={
            {2,-1},{1,-2},//右上
            {2,1},{1,2},//右下
            {-2,-1},{-1,-2},//左上
            {-2,1},{-1,2},//左下
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入行数：");
        int m = sc.nextInt();
        System.out.println("请输入列数：");
        int n = sc.nextInt();

        point = m*n;

        board = new int[m][n];

        //输入马的起始位置：
        //马的行坐标
        System.out.println("请输入马的行坐标：");
        int hx = sc.nextInt();
        //马的列坐标
        System.out.println("请输入马的列坐标：");
        int hy = sc.nextInt();
        //马在棋盘中的位置
        board[hx][hy] = 1;
        dfs(hx,hy,1);
        System.out.println(path);
    }

    private static void dfs(int hx, int hy, int i) {
       if (i==point){
           path++;
       }

       //对那八个方向进行遍历
        for (int j = 0; j <8 ; j++) {
            int nx = hx + dir[j][0];
            int ny = hy + dir[j][1];

            //判断一下该点能不能跳
            if (nx<0||nx>=m ||ny<0||ny>=n ||board[nx][ny]==1){
                continue;
            }
            board[nx][ny] = 1;
            dfs(nx,ny,i+1);

            //一定要记得清0
            board[nx][ny] = 0;
        }
    }
}
 
  