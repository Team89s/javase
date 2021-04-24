package com.igeek.javase.day12.test;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description 练习2
 * @Author chenmin
 * @Date 2020/11/17 15:19
 */
public class Test2 extends JFrame {

    public Test2(){
        super("练习2");
        this.setSize(400,360);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //内容面板
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(2,1));

        //上面板 - 边界式布局
        JPanel p1 = new JPanel(new BorderLayout());
        //下面板 - 边界式布局
        JPanel p2 = new JPanel(new BorderLayout());

        //上面板处理
        p1.add(new JButton("p1-west"),BorderLayout.WEST);
        p1.add(new JButton("p1-east"),BorderLayout.EAST);
        JPanel p3 = new JPanel(new GridLayout(2,1));
        p1.add(p3,BorderLayout.CENTER);
        p3.add(new JButton("p1-center-top"));
        p3.add(new JButton("p1-center-bottom"));

        //下面板处理
        p2.add(new JButton("p2-west"),BorderLayout.WEST);
        p2.add(new JButton("p2-east"),BorderLayout.EAST);
        JPanel p4 = new JPanel(new GridLayout(2,2));
        p2.add(p4,BorderLayout.CENTER);
        p4.add(new JButton("p4-center-top-left"));
        p4.add(new JButton("p4-center-top-right"));
        p4.add(new JButton("p4-center-bottom-left"));
        p4.add(new JButton("p4-center-bottom-right"));

        //将上下面板添加至内容面板中
        contentPane.add(p1);
        contentPane.add(p2);
    }

    public static void main(String[] args) {
        new Test2();
    }

}
