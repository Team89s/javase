package com.igeek.javase.day13.ins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/18 16:41
 */
public class MyPaint extends JFrame {

    List<Point> list  = new ArrayList<>();

    public MyPaint(){
        super("paint()案例");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = new Point(e.getX(),e.getY());
                list.add(p);
            }
        });
    }

    /**
     * 画图的方法
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        for (Point point : list) {
            //先准备一根绿色的画笔
            g.setColor(Color.BLUE);
            //实线的空心圆
            //g.drawOval(100,100,120,120);
            //实线的实心圆
            g.fillOval(point.x,point.y,5,5);
        }

        //重绘
        repaint();
    }

    public static void main(String[] args) {
        new MyPaint().setVisible(true);
    }
}
