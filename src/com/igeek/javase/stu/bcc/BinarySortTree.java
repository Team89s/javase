package com.igeek.javase.stu.bcc;

/**
 * @version 1.0
 * @Description TODO
 * @Author 毕昌成
 * @Date 2020/12/7 13:37
 */

/**
 * 删除节点的情况
 * 1删除的节点 是根节点 直接删除
 * 2删除的节点 有一棵子树
 * 3删除的节点 有两棵子树
 */
public class BinarySortTree {
    private Node root;

    public void add(int value) {
        Node tar = new Node(value);
        if (root != null) {
            root.insert(tar);
        } else {
            //为空  树没有元素
            root = tar;
        }

    }

    public void remove(int value) {
        if (root != null) {
            Node tagert = root.search(value);
            Node targetPar = root.searchParent(value);
            if (tagert != null) {
                //1删除的节点是叶子节点
                if (tagert.left == null && tagert.right == null) {
                    if (targetPar != null) {
                        if (targetPar.left == tagert) {
                            targetPar.left = null;
                        } else if (targetPar.right == tagert) {
                            targetPar.right = null;
                        }
                    } else {
                        //root 节点
                        root = null;
                    }
                } else if (tagert.left != null && tagert.right != null) {
                    //3删除的节点 有两颗子树
                    //删除右子树的最左节点 及他的后继节点
                    tagert.value = delete(tagert.right);
                } else {
                    //2删除的节点 有一颗子树
                    if (targetPar != null) {
                        if (tagert == targetPar.left) {
                            if (tagert.left != null)
                                targetPar.left = tagert.left;
                            if (tagert.right != null)
                                targetPar.left = tagert.right;
                        } else if (tagert == targetPar.right) {
                            if (tagert.left != null)
                                targetPar.right = tagert.left;
                            if (tagert.right != null)
                                targetPar.right = tagert.right;
                        }
                    } else {
                        if (tagert.left != null) {
                            root = tagert.left;
                            return ;
                        }
                        if(tagert.right != null){
                            root = tagert.right;
                            return ;
                        }

                    }
                }
            }
        }

    }

    /**
     * @param rightTagert 右子树
     * @return
     */
    private int delete(Node rightTagert) {
        //循环遍历找的 右子树的最左节点
        Node temp = rightTagert;
        while (temp.left != null) {
            temp = temp.left;
        }
        //思考点
        remove(temp.value);
//        temp = null; why?
        return temp.value;
    }

    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            //为空  树没有元素
            System.out.println("当前树为空");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int val) {
        this.value = val;
        //this = null //思考点
    }

    public boolean insert(Node target) {
        if (target.value > value) {
            if (right != null) {
                right.insert(target);
            } else {
                right = target;
                return true;
            }
        } else if (target.value < value) {
            if (left != null) {
                left.insert(target);
            } else {
                left = target;
                return true;
            }
        }
        //tagert.value==value
        return false;
    }

    public void inOrder() {
        //1先判断左子树是否为空 不为空 递归遍历左子树
        //2遍历根节点
        //3判断右子树是否为空 不为空 递归遍历右子树
        if (left != null) {
            left.inOrder();
        }
        System.out.println(this);
        if (right != null)
            right.inOrder();
    }

    public Node searchParent(int val) {
        //再找父节点 this
        if ((left != null && left.value == val) || (right != null && right.value == val))
            return this;
        if (this.value > val) {
            if (left != null)
                return left.searchParent(val);
        } else if (this.value < val) {
            if (right != null)
                return right.searchParent(val);
        }
        return null;
    }

    /**
     * 用来查找值为val 的节点
     *
     * @param val
     * @return 找到 返回Node对象 找不到null
     */
    public Node search(int val) {
        if (value == val) {
            return this;
        } else if (value < val) {
            if (right != null) {
                return right.search(val);
            }

        } else {
            if (left != null)
                return left.search(val);
        }
        return null;
    }

    /**
     * 1找自己的节点时能否带上父节点
     *
     *
     *
     *
     */
    /*public Node search(Node parent,int val){
        return null;
    }*/
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
