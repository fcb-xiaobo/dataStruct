package com.bosir.collection.set;

/**
 * @Auther: fanchengbo
 * @Date: 2022/11/1 11:16
 * @Description:
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        private E e;
        private Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node==null){
          size++;
          return new Node(e);
        }
        //插入左边
        if(e.compareTo(node.e)<0){
              node.left=add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if(root==null){
            return false;
        }
        if(e.compareTo(root.e)<0){
            return  contains(root.left,e);
        }else if(e.compareTo(root.e)>0){
            return contains(root.right.e);
        }else{
            return true;
        }
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root==null){
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    //二分搜索树的中序遍历
    public void inOrder(){
       inOrder(root);
    }

    private void inOrder(Node root) {
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }
    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if(size==0){
            throw new IllegalArgumentException("bst is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node root) {

        if(root.left==null){
            return root;
        }
        return minimum(root.left);
    }
    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right == null)
            return node;

        return maximum(node.right);
    }
}


