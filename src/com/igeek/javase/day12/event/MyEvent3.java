package com.igeek.javase.day12.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @version 1.0
 * @Description 匿名内部类实现监听
 * @Author chenmin
 * @Date 2020/11/17 15:55
 */
public class MyEvent3 extends JFrame {

    JButton btn;
    JTextField text;

    public MyEvent3(){
        super("点击事件案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Container container = this.getContentPane();

        //1.确定事件源  btn
        btn = new JButton("点击我");

        //5.注册监听器  addActionListener(listener)
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(btn.getText());
            }
        });

        text = new JTextField("文本框");
        container.add(text, BorderLayout.CENTER);
        container.add(btn, BorderLayout.SOUTH);

        /**
         * 方式三 - 匿名内部类实现监听
         */
        //适配器模式
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        new MyEvent3();
    }

}
