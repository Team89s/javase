/*
 * Created by JFormDesigner on Wed Nov 18 15:11:34 CST 2020
 */

package com.igeek.javase.day13.jpanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author 11
 */
public class MainPanel extends JPanel {

    private MyFrame my;

    public MainPanel(MyFrame my) {
        this.my = my;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label = new JLabel();
        nameLabel = new JLabel();
        pwdLabel = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label ----
        label.setText("\u4e3b\u754c\u9762");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        add(label);
        label.setBounds(105, 35, 165, 35);
        add(nameLabel);
        nameLabel.setBounds(100, 95, 175, 35);
        add(pwdLabel);
        pwdLabel.setBounds(100, 160, 175, 40);

        setPreferredSize(new Dimension(400, 300));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label;
    private JLabel nameLabel;
    private JLabel pwdLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void initMain(User user){
        nameLabel.setText(user.getName());
        pwdLabel.setText(user.getPwd());
    }
}
