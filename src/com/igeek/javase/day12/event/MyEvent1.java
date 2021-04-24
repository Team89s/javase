package com.igeek.javase.day12.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @Description 方式一 - 外部类实现监听
 * @Author chenmin
 * @Date 2020/11/17 15:55
 */
public class MyEvent1 extends JFrame {

    JButton btn;
    JTextField text;

    public MyEvent1(){
        super("点击事件案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();

        //1.确定事件源  btn
        btn = new JButton("点击我");

        //5.注册监听器  addActionListener(listener)
        btn.addActionListener(new MyListener(this));

        text = new JTextField("文本框");
        //文本内容居中
        text.setHorizontalAlignment(JTextField.CENTER);
        container.add(text, BorderLayout.CENTER);
        container.add(btn, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new MyEvent1();
    }

}

/**
 * 方式一 - 外部类实现监听
 */
//3.确定事件监听器 ActionListener
class MyListener implements ActionListener{

    //关联关系
    private MyEvent1 event;

    public MyListener(MyEvent1 event){
        this.event = event;
    }

    //2.确定事件类型  点击事件ActionEvent
    //4.确定覆盖的方法  actionPerformed(ActionEvent e)
    @Override
    public void actionPerformed(ActionEvent e) {
        //事件源触发对应的事件之后，需要执行的动作
        //将按钮上的文本内容添加至文本框中
        event.text.setText(event.btn.getText());
    }
}
