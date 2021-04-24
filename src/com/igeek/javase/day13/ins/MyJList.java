package com.igeek.javase.day13.ins;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @version 1.0
 * @Description 将集合中数据放至JList中显示
 * @Author chenmin
 * @Date 2020/11/18 16:06
 */
public class MyJList extends JFrame {

    private List<String> list;

    public MyJList(){
        super("JList案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("abc");

        JList jList = new JList(new Vector(list));
        this.getContentPane().add(jList);
    }

    public static void main(String[] args) {
        new MyJList().setVisible(true);
    }

}
