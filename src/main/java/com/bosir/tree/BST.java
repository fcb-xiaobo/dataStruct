package com.bosir.tree;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小波
 * @Description 二分搜索树
 * @date 2022/8/11-22:14
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private int size;
    private Node root;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
//        //根节点不存在,直接添加到根节点
//        if(root==null){
//            root=new Node(e);
//            size++;
//
//        }else{
//            add(root,e);
//        }
//    }
//    // 向以node为根的二分搜索树中插入元素e，递归算法
//    private void add(Node node, E e){
//        //三种情况  添加父节点   左节点   右节点
//        if(node.e.equals(e)){
//            return;
//            //左节点是
//        }else if(node.e.compareTo(e) > 0 && node.left==null){
//            node.left=new Node(e);
//            size++;
//            return;
//            //右节点
//        }else if(node.e.compareTo(e)< 0 && node.right ==null){
//            node.right=new Node(e);
//            size++;
//            return;
//        }
//        //二种递归  左 右
//        if(node.e.compareTo(e)>0){
//            add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//
//    }
        //code review   10 8 12
        root = add(root, e);
    }

    private Node add(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        //增加在左节点
        if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        }
        if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        }
        return root;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bsts = new BST<>();
        List<Integer> nums = Arrays.asList(10, 8, 6, 7,9, 13);
        for (Integer num : nums) {
            bsts.add(num);
        }
        bsts.preOrder();
        System.out.println("======================");
        System.out.println(bsts);
    }

}
