package com.igeek.javase.stu;

/**
 * @version 1.0
 * @Description TODO
 * @Author 吴涛
 * @Date 2020/12/16 13:32
 */
/*
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
1 即为活细胞（live），或 0 即为死细胞（dead）。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
示例：
输入：
[
? [0,1,0],
? [0,0,1],
? [1,1,1],
? [0,0,0]
]
输出：
[
? [0,0,0],
? [1,0,1],
? [0,1,1],
? [0,1,0]
]

 */
public class GameLife {
    public static void gameLife(int[][] board){
        //统计下标差的数组
        int[] neighbor = {0,1,-1};

        //创建一个新数组
        int rows = board.length;
        int cols = board[0].length;
        int[][] copyBoard = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }

        }

        //开始遍历每个格子周围细胞的存活个数
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
               //定义一个计数细胞存活的个数
                int live = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbor[i]==0 && neighbor[j] ==0)){
                            //求出周围细胞的下标
                           int r = row + neighbor[i];
                           int c = col + neighbor[j];
                           if((r>=0&&r<rows)&&(c>=0&&c<cols)&&copyBoard[r][c]==1){
                               live+=1;
                           }
                        }
                    }
                }

                //规则1或3
                if(copyBoard[row][col]==1 && (live>3||live<2)){
                    board[row][col]  =0;
                }
                //规则4
                if(copyBoard[row][col] ==0 && live==3){
                    board[row][col] = 1 ;
                }

            }

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameLife(board);
    }
}
