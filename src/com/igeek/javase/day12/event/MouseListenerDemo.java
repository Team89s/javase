package com.igeek.javase.day12.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @version 1.0
 * @Description 鼠标监听器
 * @Author chenmin
 * @Date 2020/11/17 19:15
 */
public class MouseListenerDemo extends JFrame {

    private JButton btn1;
    private JButton btn2;

    public MouseListenerDemo(){
        super("鼠标事件案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1));

        btn1 = new JButton("按钮1");
        btn1.addMouseListener(new MyMouseListener());

        btn2 = new JButton("按钮2");
        btn2.addMouseListener(new MyMouseListener());

        container.add(btn1);
        container.add(btn2);
    }

    private class MyMouseListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            //e.getSource() 触发事件的事件源
            /*if(e.getSource()==btn1){
                System.out.println(btn1.getText());
            }else if(e.getSource()==btn2){
                System.out.println(btn2.getText());
            }*/

            if(e.getButton()==1){
                System.out.println("左键被点击");
            }else if(e.getButton()==2){
                System.out.println("中键被点击");
            }else if(e.getButton()==3){
                System.out.println("右键被点击");
            }

            System.out.println("点击次数："+e.getClickCount());
        }
    }

    public static void main(String[] args) {
        new MouseListenerDemo().setVisible(true);
    }

}
