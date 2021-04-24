package com.igeek.javase.day13.ins;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @version 1.0
 * @Description JComboBox
 * @Author chenmin
 * @Date 2020/11/18 16:12
 */
public class MyCombox extends JFrame {

    private List<String> list;

    public MyCombox(){
        super("JCombox案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("abc");

        JComboBox box = new JComboBox(new Vector(list));
        /*box.addItem("你好");
        box.addItem("星期三");
        box.addItem("很热！");*/

        this.getContentPane().add(box);
    }

    public static void main(String[] args) {
        new MyCombox().setVisible(true);
    }
}
