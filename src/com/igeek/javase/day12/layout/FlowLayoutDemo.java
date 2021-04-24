package com.igeek.javase.day12.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description FlowLayout 流式布局
 * @Author chenmin
 * @Date 2020/11/17 14:12
 */
public class FlowLayoutDemo extends JFrame {
    //文本框
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;

    public FlowLayoutDemo(){
        //窗体基本设置
        super("流式布局案例");
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //获得内容面板
        Container container = this.getContentPane();
        //设置布局方式 - 流式布局    设置局左放置其中的组件FlowLayout.LEFT
        container.setLayout(new FlowLayout(FlowLayout.LEFT));  //默认居中

        //创建文本框组件
        text1 = new JTextField("文本框1");
        text2 = new JTextField("文本框2");
        text3 = new JTextField("文本框3");

        //添加文本框组件至内容面板
        container.add(text1);
        container.add(text2);
        container.add(text3);
    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }

}
