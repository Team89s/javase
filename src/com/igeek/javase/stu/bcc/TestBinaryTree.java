package com.igeek.javase.stu.bcc;

/**
 * @version 1.0
 * @Description TODO
 * @Author 毕昌成
 * @Date 2020/12/7 13:50
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        int arr[] = {32,58,0,28,96,-3,20};
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.inOrder();
        System.out.println("+++++++++++++++++++");
        bst.remove(32);
        bst.remove(0);
        bst.remove(58);
        bst.remove(20);
        bst.remove(28);
        bst.remove(96);
//        bst.remove(-3);
        bst.inOrder();
    }
}
