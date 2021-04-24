package com.igeek.javase.day12.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @Description 练习3 - 简易计算器
 * @Author chenmin
 * @Date 2020/11/17 16:45
 *
 * 3个文本框  JTextField
 * 1个文本    JLabel
 * 1个按钮    JButton
 */
public class Test3 extends JFrame {

    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JLabel label;
    private JButton button;

    public Test3(){
        this.setTitle("简易计算器");
        this.setSize(400,100);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        //创建组件
        text1 = new JTextField(5);
        text2 = new JTextField(5);
        text3 = new JTextField(10);
        label = new JLabel("+");
        label.setHorizontalAlignment(JLabel.CENTER);
        button = new JButton("=");

        //给button按钮 = 添加点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(text1.getText());
                int b = Integer.parseInt(text2.getText());
                text3.setText((a+b)+"");
            }
        });

        //添加组件
        contentPane.add(text1);
        contentPane.add(label);
        contentPane.add(text2);
        contentPane.add(button);
        contentPane.add(text3);
    }

    public static void main(String[] args) {
        new Test3();
    }

}
