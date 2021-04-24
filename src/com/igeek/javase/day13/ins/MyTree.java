/*
 * Created by JFormDesigner on Wed Nov 18 17:09:01 CST 2020
 */

package com.igeek.javase.day13.ins;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * @author 11
 */
public class MyTree extends JFrame {
    public MyTree() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tree1 = new JTree();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- tree1 ----
            tree1.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("\u7ba1\u7406\u7cfb\u7edf") {
                    {
                        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("\u589e\u52a0");
                            node1.add(new DefaultMutableTreeNode("\u589e\u52a0\u7528\u6237"));
                            node1.add(new DefaultMutableTreeNode("\u589e\u52a0\u7ba1\u7406\u5458"));
                        add(node1);
                        add(new DefaultMutableTreeNode("\u5220\u9664"));
                        add(new DefaultMutableTreeNode("\u67e5\u8be2"));
                    }
                }));
            scrollPane1.setViewportView(tree1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 25, scrollPane1.getPreferredSize().width, 195);

        //======== scrollPane2 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"123", "abc", null, null, null},
                    {"456", "aaa", null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "username", "password", null, null, null
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Object.class, Object.class, Object.class, Object.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane2.setViewportView(table1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(195, 20, 175, 182);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTree tree1;
    private JScrollPane scrollPane2;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
