package com.igeek.javase.day12.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @Description CardLayout  卡片式布局
 * @Author chenmin
 * @Date 2020/11/18 11:33
 */
public class CardLayoutDemo extends JFrame {

    public CardLayoutDemo(){
        super("卡片式布局案例");
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        //存储按钮，按照卡片式布局存放
        JPanel p1 = new JPanel();
        //卡片式布局对象
        CardLayout card = new CardLayout();
        p1.setLayout(card);
        container.add(p1,BorderLayout.CENTER);
        for (int i = 0; i < 5; i++) {
            p1.add(new JButton("按钮"+(i+1)));
        }

        //存储上下按钮，按照流式布局存放
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        container.add(p2,BorderLayout.SOUTH);
        JButton preButton = new JButton("上一张");
        JButton nextButton = new JButton("下一张");
        p2.add(preButton);
        p2.add(nextButton);

        //上一张
        preButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(p1);
            }
        });

        //上一张
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.next(p1);
            }
        });
    }

    public static void main(String[] args) {
        new CardLayoutDemo().setVisible(true);
    }
}
