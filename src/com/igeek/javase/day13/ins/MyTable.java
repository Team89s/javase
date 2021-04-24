package com.igeek.javase.day13.ins;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description JTable
 * @Author chenmin
 * @Date 2020/11/18 16:06
 */
public class MyTable extends JFrame {

    private List<User> list = new ArrayList<>();

    public MyTable(){
        super("JTable案例");
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        list.add(new User("张三","123"));
        list.add(new User("李四","123"));
        list.add(new User("王五","123"));
        list.add(new User("赵六","123"));

        Container container = this.getContentPane();
        JScrollPane scrollPane = new JScrollPane();
        container.add(scrollPane);

        //创建一个JTable组件
        JTable table = new JTable();
        scrollPane.setViewportView(table);

        //添加数据至JTable组件
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String[] title = {"username","password"};
        Object[][] data = new Object[list.size()][title.length];
        //添加数据
        for (int i = 0; i < list.size(); i++) {
            //每行有两列数据
            data[i] = new Object[]{
                    list.get(i).getUsername(),
                    list.get(i).getPassword()
            };
        }
        model.setDataVector(data,title);
    }

    public static void main(String[] args) {
        new MyTable().setVisible(true);
    }

}
class User{
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + "}";
    }
}
