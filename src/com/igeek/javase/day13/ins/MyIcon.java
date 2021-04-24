package com.igeek.javase.day13.ins;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @version 1.0
 * @Description Icon图标
 * @Author chenmin
 * @Date 2020/11/18 16:52
 */
public class MyIcon extends JFrame {

    public MyIcon(){
        super("icon案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(100,200));
        //获取与本类同路径下的资源图片
        URL url = MyIcon.class.getResource("0.jpg");
        label.setIcon(new ImageIcon(url));
        this.getContentPane().add(label);
    }

    public static void main(String[] args) {
        new MyIcon().setVisible(true);
    }

}
