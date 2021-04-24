package com.igeek.javase.day14.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @Description Lambda 表达式
 * @Author chenmin
 * @Date 2020/11/20 9:37
 *
 * lambda表达式简化匿名内部类，首先要求是接口，其次是该接口只有一个抽象方法。
 * 满足以上条件，就会称此接口为“函数式接口”
 *
 * 省略格式
 * 1.省略参数类型  例如：s (a,b)
 * 2.当参数列表中只有一个参数时，可以省略小括号()  例如：s    若是无参()，或者是有多个参数时(a,b)
 * 3.当代码块中只有一个语句时，可以省略大括号{}和分号;
 * 若当前是有返回值return，这个return关键字必须删掉
 */
public class LambdaDemo1 extends JFrame{
    public LambdaDemo1(){
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

        JButton button = new JButton("按钮，点击我");
        this.getContentPane().add(button);

        //通过外部类，给按钮绑定监听器
        button.addActionListener(new MyActionListener());

        //简化1：匿名内部类
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击按钮了2！");
            }
        });

        //简化2：Lambda表达式  (参数类型 参数名称) -> { 代码语句 }
        button.addActionListener((ActionEvent e) -> {
            System.out.println("点击按钮了3！");
        });

        //简化3：Lambda表达式
        button.addActionListener(e -> System.out.println("点击按钮了3！"));

    }

    public static void main(String[] args) {
        new LambdaDemo1().setVisible(true);
    }
}
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("点击按钮了1！");
    }
}
