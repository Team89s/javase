package com.igeek.javase.day13.jpanel;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/18 15:03
 */
public class MyFrame extends JFrame {

    RegistPanel registPanel;
    LoginPanel loginPanel;
    MainPanel mainPanel;
    UserDao dao;

    Container container;
    CardLayout card;

    public MyFrame() {
        dao = new UserDao();
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        registPanel = new RegistPanel(this);
        loginPanel = new LoginPanel(this);
        mainPanel = new MainPanel(this);

        container = this.getContentPane();
        card = new CardLayout();
        container.setLayout(card);

        container.add(registPanel, "regist");
        container.add(loginPanel, "login");
        container.add(mainPanel, "main");
    }

    //跳转到指定的资源Panel中
    public void skip(String resource) {
        //CardLayout card = (CardLayout)this.getParent().getLayout();
        //card.show(this.getParent(),resource);
        //卡片式布局中的跳转方法 show(当前所在的Panel的父容器,添加组件时取的名字)
        card.show(container, resource);
    }

    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }

}
