package com.igeek.javase.stu.test.taov;

/**
 * @Description TODO
 * @Author 陶威
 * @Name Test
 * @Date 2020/12/7 19:19
 */
public class Test {
    public static void main(String[] args) {
        int[] arr={32,58,0,28,96,-3,20};
        BinarySortTree bst=new BinarySortTree();
        for (int i : arr) {
            bst.add(i);
        }
        bst.inOrder();
        System.out.println("========================");

        bst.remove(28);

        bst.inOrder();

    }
}
