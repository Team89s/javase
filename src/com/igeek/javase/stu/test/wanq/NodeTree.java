package com.igeek.javase.stu.test.wanq;

/**
 * @version 1.0
 * @Description:
 * @Author VickW
 * @Date 2020/12/7 20:23
 */
public class NodeTree {
    private Node root; //根结点

    public NodeTree() {
    }

    public NodeTree(Node root) {
        this.root = root;
    }

    /**
     * @methodName insert
     * @Description: 插入结点
     * @param val
     */
    public void insert(int val){
        Node node = new Node(val);
        if (root == null) root = node;
        else root.insert(node);
    }

    /**
     * @methodName delete
     * @Description: 删除结点
     * @param val
     */
    public void delete(int val){
        //不存在这个结点
        if (root == null ) return ;
        else { //存在这个结点
            Node node = root.search(val);   //node不为空
            Node nodeParent = root.searchParent(val);  //nodeParent可能为空（可能没有父结点），可能不为空
            if (node.left == null && node.right == null) { //叶子结点 左右子树均为空
                if (nodeParent != null) { //父结点不为null
                    if (nodeParent.left != null && nodeParent.left == node) { //在要删除的结点在父结点的左子树
                        nodeParent.left = null;
                    } else if (nodeParent.right != null && nodeParent.right == node) { //要删除的结点在父结点的右子树
                        nodeParent.right = null;
                    }
                }else root = null;  //父结点为空
            }else if (node.left != null && node.right == null){ //左子树不为空
                if (nodeParent != null) { //父结点不为null
                    //要删除的结点在父结点的右子树
                    if (nodeParent.right != null && nodeParent.right == node) {
                        nodeParent.right = node.left;
                    }
                    //在要删除的结点在父结点的左子树
                    else if (nodeParent.left != null && nodeParent.left == node) {
                        nodeParent.left = node.left;
                    }
                }else root = node.left;  //父结点为空

            }else if (node.right != null && node.left == null){ //右子树不为空
                if (nodeParent != null) { //父结点不为null
                    //要删除的结点在父结点的右子树
                    if (nodeParent.right == node) {
                        nodeParent.right = node.right;
                    }
                    //在要删除的结点在父结点的左子树
                    else if (nodeParent.left == node) {
                        nodeParent.left = node.right;
                    }else root = node.right;  //父节点为空
                }
            }else if (node.right != null && node.left != null){ //左右子树均不为空
                //将node的右子树的最左结点赋到node上
                Node temp = node.right;
                while (temp.left != null){
                    temp = temp.left;
                }
                delete(temp.val); //删除temp结点
                node.val = temp.val; //将node结点值更新
            }
        }
    }

    /**
     * @methodName inOrderTraversal
     * @Description: 中序遍历
     */
    public void inOrderTraversal(){
        if (root == null) System.out.println("树为空");
        else root.inOrderTraversal();
    }

}
