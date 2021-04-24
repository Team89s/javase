package com.igeek.javase.stu.test.wanq;

/**
 * @version 1.0
 * @Description: 结点类 - 存储每一个结点信息
 * @Author VickW
 * @Date 2020/12/7 18:31
 *
 * 注意：二叉排序树中没有值相同的节点，使用就不用考虑相同值的情况
 */
public class Node {
    Node right; //右子树
    Node left;  //左子树
    int val;    //根结点值

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    /**
     * @methodName insert
     * @Description: 插入结点
     * @param node
     */
    public void insert(Node node){
        //根结点不为空 没有相同结点值的情况
        //node的val小于this的val 插入到左子树
        if (this.val > node.val) {
            if (this.left != null) left.insert(node);
            else this.left = node;
        }else { //node的val大于this的val 插入到右子树
            if (this.right != null) right.insert(node);
            else this.right = node;
        }

    }

    /**
     * @methodName search
     * @Description: 查找结点
     * @param val
     */
    public Node search(int val){
        if (this.val == val) return this;
        else if (this.left != null && this.val > val){
            //node的val小于this的val 从左子树迭代查找
            return this.left.search(val);
        }else if (this.right != null && this.val < val){
            //node的val大于this的val 从右子树迭代查找
            return this.right.search(val);
        }
        return null;
    }

    /**
     * @methodName searchParean
     * @Description: 查找结点node的父结点
     * @param val
     */
    public Node searchParent(int val){
        if ((left != null && left.val == val) || (right != null && right.val == val)) return this;
        else if (this.left != null && this.val > val){
            //node的val小于this的val 从左子树迭代查找
            return this.left.searchParent(val);
        }else if (this.right != null && this.val < val){
            return this.right.searchParent(val);
        }
        return null;
    }

    /**
     * @methodName inOrderTraversal
     * @Description: 中序遍历
     */
    public void inOrderTraversal(){
        if (this.left != null) left.inOrderTraversal();
        System.out.print(this.val+" ");
        if (this.right != null) right.inOrderTraversal();
    }
}
