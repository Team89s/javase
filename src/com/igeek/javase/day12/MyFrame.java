package com.igeek.javase.day12;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description 窗体JFrame
 * @Author chenmin
 * @Date 2020/11/17 11:08
 */
public class MyFrame extends JFrame{

    public MyFrame(){
        super("这是一个窗体");
        //参数：x轴  y轴  宽   高
        this.setBounds(400,260,350,400);
        //参数：宽   高
        this.setSize(300,350);
        //当前窗体不可拖拽  大小不可变
        this.setResizable(false);
        //居中
        this.setLocationRelativeTo(null);
        //通过JFrame获得内容面板Container容器
        Container contentPane = this.getContentPane();
        //设置背景色
        contentPane.setBackground(new Color(208, 190, 246));
        //修改窗体默认关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }

}
