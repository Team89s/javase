package com.igeek.javase.day12;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @Description JPanel画布面板
 * @Author chenmin
 * @Date 2020/11/17 11:25
 *
 * JPanel 需要添加在JFrame之上才可以显示
 *       add              add
 * 组件 ------>  JPanel -------> Container -> JFrame
 */
public class MyPanel extends JPanel {

    public static void main(String[] args) {
        MyNewFrame my1 = new MyNewFrame(200,200,200,200,null);
        MyNewFrame my2 = new MyNewFrame(410,200,200,200,new Color(100,240,245));
        MyNewFrame my3 = new MyNewFrame(200,410,200,200,new Color(100,150,245));
        MyNewFrame my4 = new MyNewFrame(410,410,200,200,new Color(240,120,245));

        Container container = my1.getContentPane();
        //画布添加在Container容器上
        MyPanel p1 = new MyPanel();
        p1.setBackground(new Color(100,120,245));
        container.add(p1);
        //按钮添加在画布JPanel上
        JButton b1 = new JButton("按钮1");
        p1.add(b1);
    }

}
class MyNewFrame extends JFrame{
    public MyNewFrame(int x, int y, int width, int height, Color color){
        this.setBounds(x,y,width,height);
        this.setVisible(true);
        this.getContentPane().setBackground(color);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
