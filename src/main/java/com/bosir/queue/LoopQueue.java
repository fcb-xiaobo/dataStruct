//package com.bosir.queue;
///**
// *循环队列
// */
//public class LoopQueue<E> implements Queue<E> {
//    private E[] data;
//    private int front,tail;
//    private int size;
//
//    public LoopQueue(int capacity){
//       data= (E[]) new Object[capacity+1];
//        front = 0;
//        tail = 0;
//        size = 0;
//    }
//
//    public LoopQueue(){
//        this(10);
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return front==tail;
//    }
//    //入队操作
//    public void enqueue(E e) {
//      /*
//       * 队列满了
//       * 如何判断:因为是循环队列,tail可能还在head前面(数组的方式)
//       * 因为数组空了一个位置,所以判断方式是tail+1 % 数组的长度 ==front 说明数组就满了
//       */
//       if((tail+1)%data.length==front){
////             resize();
//       }
//       data[tail]=e;
//       tail=(tail+1)%data.length;
//       size++;
//    }
//
//    /**
//     * 思路:取出数据,维护front,是否涉及缩容
//     * @param
//     * @return E
//     */
//    public E dequeue() {
//        if(isEmpty()){
//            throw new IllegalArgumentException(String.format("loopQueue is empty"));
//        }
//        E tmp=data[front];
//        // help gc
//        data[front]=null;
//        //维护front
//        front=(front+1)%data.length;
//        size--;
//        //缩容
//        return tmp;
//    }
//
//    public E getFront() {
//        if(isEmpty()){
//            throw new IllegalArgumentException(String.format("loopQueue is empty"));
//        }
//        return data[front];
//    }
//}
