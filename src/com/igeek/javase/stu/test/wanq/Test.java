package com.igeek.javase.stu.test.wanq;

/**
 * @version 1.0
 * @Description:
 * @Author VickW
 * @Date 2020/12/7 20:43
 */
public class Test {
    public static void main(String[] args) {
        NodeTree tree = new NodeTree(null);
        int[] arr = {32,58,0,28,96,-3,20,15,98,45};
        for (int v : arr) {
            tree.insert(v);
        }
        tree.inOrderTraversal();

        System.out.println("\n----------------------------");
        tree.delete(-3);
        tree.delete(98);
        tree.delete(0);
        tree.delete(15);
        tree.delete(32);
        tree.delete(96);
        tree.inOrderTraversal();
    }
}
