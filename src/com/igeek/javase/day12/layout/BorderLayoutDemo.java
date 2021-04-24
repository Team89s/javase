package com.igeek.javase.day12.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description BorderLayout 边界式布局
 * @Author chenmin
 * @Date 2020/11/17 14:23
 */
public class BorderLayoutDemo extends JFrame {

    private JButton north;
    private JButton south;
    private JButton east;
    private JButton west;
    private JButton center;

    public BorderLayoutDemo(){
        super("边界式布局案例");
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //获得内容面板
        Container container = this.getContentPane();
        //设置边界式布局方式
        container.setLayout(new BorderLayout());

        //创建组件
        north = new JButton("北");
        south = new JButton("南");
        west = new JButton("西");
        east = new JButton("东");
        center = new JButton("中");

        //添加组件
        container.add(north,BorderLayout.NORTH);
        container.add(south,BorderLayout.SOUTH);
        container.add(west,BorderLayout.WEST);
        container.add(east,BorderLayout.EAST);
        container.add(center,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new BorderLayoutDemo();
    }
}
