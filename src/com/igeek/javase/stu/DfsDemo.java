package com.igeek.javase.stu;

import java.util.Scanner;

/**
 * @version 1.0
 * @Description 马在中国象棋以日字形规则移动。
 * 请编写一段程序，给定n*m大小的棋盘，以及马的初始位置(x，y)，
 * 要求不能重复经过棋盘上的同一个点，计算马可以有多少途径遍历棋盘上的所有点
 * @Author 冯世航
 * @Date 2020/12/1 13:45
 */
public class DfsDemo {
    //定义一些静态常量
    private static int point;//总点数
    private static int m,n;//定义棋盘的大小
    private static int path;//可以走的路径数目
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
        //输入棋盘的大小
        m = sc.nextInt();
        n = sc.nextInt();
        //计算棋盘上的点数
        point = n*m;
        board = new int[m][n];
        //输入马的起始位置
        int sX = sc.nextInt();
        int sY = sc.nextInt();
        board[sX][sY]=1;
        dfs(sX,sY,1);
        System.out.println(path);
    }
    private static void dfs(int sX, int sY, int i) {
        //遍历结束
        if(i==point){
            path++;
            return;
        }
        //对八个方向进行遍历
        for (int j = 0; j <8 ; j++) {
            //计算下一个点
            int nX = sX+dir[j][0];
            int nY = sY+dir[j][1];
            //判断该点可不可以跳
            if(nX<0||nX>=m||nY<0||nY>=n||board[nX][nY]==1)continue;
            //让当前的点数值变为1，表示已经跳过
            board[nX][nY]=1;
            dfs(nX,nY,i+1);
            //当当前方向调完的时候需要对棋盘进行清0
            board[nX][nY]=0;
        }
    }

}
