package com.bosir.heap;


/**
 * @author 小波
 * @Description 使用数组实现的最大堆
 * @date 2022/10/8-21:50
 */
public class MaxHeap<E extends Comparable<E>> {
    private MyArray<E> array;

    public MaxHeap(int capacity) {
        array = new MyArray<E>(capacity);
    }

    public MaxHeap() {
        this(10);
    }

    // 返回堆中的元素个数
    public int getSize() {
        return array.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }
    //向堆中添加元素
    public void add(E e){
        array.addLast(e);
        siftUp(array.getSize()-1);
    }

    private void siftUp(int i) {

    }

}
