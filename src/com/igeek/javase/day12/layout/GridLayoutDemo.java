package com.igeek.javase.day12.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description GridLayout 网格式布局
 * @Author chenmin
 * @Date 2020/11/17 14:32
 */
public class GridLayoutDemo extends JFrame{

    private JButton[] buttons = new JButton[9];  //null

    public GridLayoutDemo(){
        //窗体基本设置
        super("网格式布局案例");
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,3));

        //自适应
        //this.pack();

        for (int i = 0; i <buttons.length; i++) {
            //创建按钮组件
            buttons[i] = new JButton("按钮"+(i+1));
            //添加按钮
            container.add(buttons[i]);
        }
    }

    public static void main(String[] args) {
        new GridLayoutDemo();
    }

}
