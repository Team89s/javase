package com.igeek.javase.stu.test;

/**
 * @Description 二叉排序树
 * @Author Lemon  陈青玲
 * @Date 2020/12/7 18:12
 */
public class BinarySortTree {
    //根节点
    private Node root;
    //插入节点
    public void add(int value){
        //新建一个节点
        Node target=new Node(value);
        if(root==null){
            //根节点为空，则将该节点作为根节点
            root=target;
        }else {
            //根节点插入该节点
            root.insert(target);
        }
    }

    //排序
    public void sort(){
        if(root==null){
            System.out.println("当前树为空！");
        }else{
            root.sort();
        }
    }

    //删除节点
    public  void remove(int value){
        if(root!=null){
            //目标值所在的节点
            Node target = root.search(value);
            //目标值所在节点的父亲节点
            Node targert_par = root.searchParent(value);
            if(target!=null){
                //如果目标节点为叶子节点，则直接删除
                if(target.left==null && target.right==null ) {
                    if(targert_par!=null){
                        if(target==targert_par.left){
                            //目标节点为父亲节点的左孩子
                            targert_par.left=null;
                        }else{
                            targert_par.right=null;
                        }
                    }else{
                        root=null;
                    }

                }else if(target.right!=null && target.left!=null){
                    //目标节点不是叶子节点,左右子树都不为空
                    target.value=delete(target.right);
                }else{
                    //目标节点的左子树或右子树不为空
                    if(targert_par!=null){
                        if(targert_par.left==target){
                            //目标节点为其父亲节点的左孩子
                            if(target.left!=null){
                                //左子树不为空，将左子树作为父亲节点的左节点
                                targert_par.left=target.left;
                            }
                            if(target.right!=null){
                                //右子树不为空，将右子树作为父亲节点的左节点
                                targert_par.left=target.right;
                            }
                        }else{
                            //目标节点为其父亲节点的右孩子
                            if(target.right!=null){
                                targert_par.right=target.right;
                            }
                            if(target.left!=null){
                                targert_par.right=target.left;
                            }
                        }
                    }else{
                        //将右子树的最左节点赋给根节点
                        if(target.left!=null){
                            root=target.left;
                            return ;
                        }
                        if(target.right!=null){
                            root=target.right;
                            return ;
                        }
                    }
                }
            }
        }
    }

    public int delete(Node node){
        Node temp=node;
        while(node.left!=null){
            //寻找目标节点的右子树的最左子树
            temp=temp.left;
        }
        remove(temp.value);
        return temp.value;
    }

    public static void main(String[] args) {
        Integer[] arr={12,23,43,21,98,67};
        BinarySortTree tree=new BinarySortTree();
        tree.sort();
        System.out.println("==============添加节点并排序==============");
        for (Integer i : arr) {
            tree.add(i);
        }
        tree.sort();
        System.out.println("===============删除节点===============");
        tree.remove(23);
        tree.remove(21);
        tree.remove(98);
        tree.sort();
    }
}


//定义节点类
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value=value;
    }

    //插入节点
    public boolean insert(Node node){
        //如果目标节点的值   >  当前节点的值
        if(node.value>value){
            //当前节点的右子树不为空，将目标节点插入该节点的右子树中
            if(this.right!=null){
                this.right.insert(node);
                return true;
            }else{
                //当前节点的右子树为空，则将目标节点直接作为当前节点的右节点
                this.right=node;
                return true;
            }

        }else if(node.value<value){
            //目标节点的值  <  当前节点的值
            //当前节点的左子树不为空，将目标节点插入该节点的左子树中
            if(this.left!=null){
                this.left.insert(node);
                return true;
            }else{
                //当前节点的左子树为空，则将目标节点直接作为当前节点的左节点
                this.left=node;
                return true;
            }
        }
        return false;
    }

    //遍历  中序遍历   从小到大的顺序排列
    public void sort(){
        //先遍历左子树
        if(this.left!=null){
            //递归
            this.left.sort();
        }
        //中间节点    叶子节点  直接输出该节点的值
        System.out.println(this);
        //遍历右子树
        if(this.right!=null){
            this.right.sort();
        }

    }

    //查找值为value的节点
    public Node search(int val){
        if(this.value==val){
            //当前节点值等于val值，返回该节点
            return this;
        }else if(this.value<val){
            //当前节点的值小于该值，则遍历右子树
            if(this.right!=null){
                return this.right.search(val);
            }
        }else if(this.value>val){
            //当前节点的值大于该值，则遍历左子树
            if(this.left!=null){
                return this.left.search(val);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Node="+this.value;
    }

    //寻找父亲节点
    public Node searchParent(int val){
        //当前节点的左孩子的值或右孩子的值等于  目标值，
        // 则当前节点为为目标值所在节点的父亲节点
        if((this.left!=null && this.left.value==val) || (this.right!=null && this.right.value==val)){
            return this;
        }else if(this.value>val){
            //当前节点的值大于目标值
            //向左遍历
            if(this.left!=null){
                return this.left.searchParent(val);
            }
        }else if(this.value<val){
            //当前节点的值小于目标值
            //向右遍历
            if(this.right!=null){
                return this.right.searchParent(val);
            }
        }
        return null;
    }
}


