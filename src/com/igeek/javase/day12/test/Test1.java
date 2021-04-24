package com.igeek.javase.day12.test;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description 练习1 - 在窗体中有4个面板，显示成田字格
 * @Author chenmin
 * @Date 2020/11/17 14:42
 */
public class Test1 extends JFrame {

    public Test1(){
        super("练习1");
        //窗体基本设置
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(2,2));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        p1.setBounds(0,0,200,200);
        p2.setBounds(200,0,200,200);
        p3.setBounds(0,200,200,200);
        p4.setBounds(200,200,200,200);

        p1.setBackground(new Color(100,120,210));
        p2.setBackground(new Color(200,120,100));
        p3.setBackground(new Color(100,240,120));
        p4.setBackground(new Color(200,120,210));

        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
    }

    public static void main(String[] args) {
        new Test1();
    }

}
