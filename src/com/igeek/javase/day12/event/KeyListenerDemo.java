package com.igeek.javase.day12.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @version 1.0
 * @Description KeyListener 键盘监听器
 * @Author chenmin
 * @Date 2020/11/17 18:58
 */
public class KeyListenerDemo extends JFrame {

    private JTextField text;

    public KeyListenerDemo(){
        super("键盘事件案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        text = new JTextField("文本框",10);
        container.add(text);

        /**
         * 1.确定事件源  text
         * 2.确定事件类型 KeyEvent
         * 3.确定事件监听器 keyListener
         * 4.确定重写监听器中的方法
         * 5.事件源注册监听器
         */
        text.addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                //e.getSource() 获取触发的事件源
                System.out.println(e.getSource());
            }

            //键盘释放
            @Override
            public void keyReleased(KeyEvent e) {
                //e.getKeyCode() 获取按下的键的值
                System.out.println(e.getKeyCode());
            }

            //输入某个字符时调用
            /*@Override
            public void keyTyped(KeyEvent e){
                System.out.println(e.getSource());
                System.out.println(e.getKeyCode());
            }*/
        });

    }

    public static void main(String[] args) {
        new KeyListenerDemo().setVisible(true);
    }

}
