package com.igeek.javase.stu.test.taov;

/**
 * @Description TODO
 * @Author taov
 * @Name BinarySortTree
 * @Date 2020/12/7 18:28
 */
public class BinarySortTree {
    private Node node;

    //添加元素的方法
    public void add(int value){
        Node insertNode=new Node(value);
        if (node!=null){//当前节点
            node.insert(insertNode);
        }else {
            node=insertNode;
        }
    }

    //遍历二叉树
    public void inOrder(){
        if (node!=null){
            node.inOrder();
        }else {
            System.out.println("当前树为空");
        }
    }

    //删除元素

    public void remove(int value){
        if (node!=null){
            Node deleteNode=node.search(value);//删除的节点
            Node dnParent=node.findParent(value);//删除的节点的父节点

            if (deleteNode!=null){

                //删除的是叶子节点
                if(deleteNode.left==null && deleteNode.right==null){
                    if (dnParent!=null){
                        if (dnParent.left==deleteNode){
                            dnParent.left=null;
                        }else if (dnParent.right==deleteNode){
                            dnParent.right=null;
                        }
                    }else {
                        node=null;
                    }
                }else if (deleteNode.right!=null && deleteNode.left!=null){
                    //删除的节点有两个孩子,此时需要找到删除的节点的右子树的最左节点，将该节点与 需要删除的节点的左子树连接
                    deleteNode.value=select(deleteNode.right);
                } else{ //删除的节点有一个孩子
                    if (dnParent!=null){
                        if (deleteNode==dnParent.left){//删除节点是原父节点的左孩子
                            //将删除节点的左孩子或者右孩子连接到原父节点左孩子的位置
                            if (deleteNode.right!=null){
                                dnParent.left=deleteNode.right;
                            }
                            if (deleteNode.left!=null){
                                dnParent.left=deleteNode.left;
                            }
                        }else if (deleteNode==dnParent.right){//删除节点是原父节点的右孩子
                            //将删除节点的左孩子或者右孩子连接到原父节点右孩子的位置
                            if (deleteNode.right!=null){
                                dnParent.right=deleteNode.right;
                            }
                            if (deleteNode.left!=null){
                                dnParent.right=deleteNode.left;
                            }
                        }
                    }else{
                        //删除的是根节点把左孩子或者右孩子
                        if (deleteNode.left!=null){
                            node = deleteNode.left;
                            return;
                        }
                        if (deleteNode.right!=null){
                            node = deleteNode.right;
                            return;
                        }
                    }

                }
            }


        }
    }
    //找到右子树的最左节点
    public int  select(Node dpRight){
        Node temp=dpRight;
        while (temp.left!=null){
            temp=temp.left;
        }

        remove(temp.value);
        return temp.value;
    }

}

class Node{
    int value;//当前节点的值
    Node left;
    Node right;

    public Node(int value){
        this.value=value;
    }

    //插入方法
    public void insert(Node node){
        if (node.value>value){//插入的值大于value,位于节点右边
            if (right!=null){//右节点存在值，递归继续插入
                right.insert(node);
            }else {
                right=node;
            }
        }else if (node.value<value){//插入的值大于value,位于节点左边
            if (left!=null){//左节点存在值，递归继续插入
                left.insert(node);
            }else {
                left=node;
            }
        }
    }

    //递归遍历节点
    public void inOrder(){//left<this<right
        if (left!=null){
            left.inOrder();
        }

       System.out.println(this);//打印当前根节点；

        if (right!=null){
            right.inOrder();
        }

    }

    //寻找父节点
    public Node findParent(int value){
        //当节点的左孩子或者右孩子不为空且值为给定值，则该节点为所要找的父节点
        if( (left!=null && left.value==value ) || (right!=null && right.value==value))
            return this;
        if (this.value>value){//当前节点的值大于所要寻找的值，左子树递归寻找
            if (left!=null){
                return left.findParent(value);
            }
        }else if (this.value<value){//当前节点的值小于所要寻找的值，右子树递归寻找
            if (right!=null){
                return right.findParent(value);
            }
        }
        return null;
    }

    //寻找值为value的节点
    public Node search(int val){
        if (value==val){
            return this;
        }else if (value>val){
            if (left!=null)
            return left.search(val);
        }else if (value<val){
            if (right!=null){
                return right.search(val);
            }

        }

        return null;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}