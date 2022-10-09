package com.bosir.heap;

import com.bosir.array.Array;

/**
 * @author 小波
 * @Description 使用数组实现的最大堆
 * @date 2022/10/8-21:50
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<E>(capacity);
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
        return array.getArrayIsEmpty();
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    public int parant(int index){
        if(index<=0){
            throw new IllegalArgumentException("index 不能小于或者小于0");
        }
        return (index-1)/2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index){
        return index*2+1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index){
        return index*2+2;
    }

    //  向堆中添加元素

    public void add(E e){
        array.insertTailElement(e);
        siftUp(array.getSize()-1);
    }

    private void siftUp(int i) {
        //索引要大于0 并且该节点的父节点
        while (i>0 &&array.getIndexElement(parant(i)).compareTo(array.getIndexElement(i))<0){
             //传入二个索引,一个当前元素的索引,一个当前元素父节点的索引
             array.swap(i,parant(i));
             i=parant(i);
        }
    }
    //取出堆中最大元素
    public E findMax(){

        if(array.getSize()<=0){
            throw new IllegalArgumentException("can not finMax when heap is Empty");
        }
        return array.getIndexElement(0);
    }


}
