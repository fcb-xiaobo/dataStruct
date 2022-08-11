package com.bosir.tree;

/**
 * @author 小波
 * @Description 二分搜索树
 * @date 2022/8/11-22:14
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        private Node e;
        private Node left,right;

        public Node(Node node){
            this.e=node;
            left=null;
            right=null;
        }
    }
    private int size;
    private Node root;

    public BST(Node node){
        root=node;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
