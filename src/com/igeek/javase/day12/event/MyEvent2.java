package com.igeek.javase.day12.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @version 1.0
 * @Description 内部类实现监听
 * @Author chenmin
 * @Date 2020/11/17 15:55
 */
public class MyEvent2 extends JFrame {

    JButton btn;
    JTextField text;

    public MyEvent2(){
        super("点击事件案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Container container = this.getContentPane();

        //1.确定事件源  btn
        btn = new JButton("点击我");

        //5.注册监听器  addActionListener(listener)
        //btn.addActionListener(new MyListener());

        text = new JTextField("文本框");
        container.add(text, BorderLayout.CENTER);
        container.add(btn, BorderLayout.SOUTH);

        //给当前窗体注册窗体监听器 - 关闭事件
        this.addWindowListener(new MyWindowListener());
    }

    /**
     * 方式二 - 内部类实现监听
     */
    private class MyWindowListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        //窗体正在关闭
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        //窗体已关闭
        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    public static void main(String[] args) {
        new MyEvent2();
    }

}
