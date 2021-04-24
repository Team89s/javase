/*
 * Created by JFormDesigner on Wed Nov 18 16:53:01 CST 2020
 */

package com.igeek.javase.day13.ins;

import javax.swing.*;
import java.awt.*;

/**
 * @author 11
 */
public class My extends JFrame {
    public My() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("text");
        button1.setIcon(new ImageIcon("C:\\Users\\cp\\Desktop\\0.jpg"));
        contentPane.add(button1);
        button1.setBounds(70, 90, 240, 50);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
