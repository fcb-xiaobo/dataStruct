package com.bosir.queue.loop;

import com.bosir.queue.MyQueue;


/**
 *基础数组实现的循环队列
 *
 *
 * 核心
 * 数组空 => front==tail
 * 数组满 => front=tail+1%data.length
 */
public class MyLoopQueue<E> implements MyQueue<E> {
    private E[] data;
    private int front,tail;
    //size+1
    private int size;

    public MyLoopQueue(int capacity){
       data= (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public MyLoopQueue(){
        this(10);
    }

    public int getSize() {
        return size;
    }
    public int getCapacity(){
        return data.length - 1;
    }

    public boolean isEmpty() {
        return front==tail;
    }
    //入队操作
    public void enqueue(E e) {
      /*
       * 队列满了
       * 如何判断:因为是循环队列,tail可能还在head前面(数组的方式)
       * 因为数组空了一个位置,所以判断方式是tail+1 % 数组的长度 ==front 说明数组就满了
       */
       if((tail+1)%data.length==front){
             resize(getCapacity()*2);
       }
       data[tail]=e;
       tail=(tail+1)%data.length;
       size++;
    }

    private void resize(int i) {
        E[] newDatas= (E[]) new Object[i];
        for (int j = 0; j < data.length; j++) {
            newDatas[j]=data[(j+front)%data.length];
        }
        data=newDatas;
        front=0;
        tail=size;
    }

    /**
     * 思路:取出数据,维护front,是否涉及缩容
     * @param
     * @return E
     */
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException(String.format("loopQueue is empty"));
        }
        E tmp=data[front];
        // help gc
        data[front]=null;
        //维护front
        front=(front+1)%data.length;
        size--;
        //缩容
        return tmp;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException(String.format("loopQueue is empty"));
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("MyLoopQueue  size [ %d ] , capacity  [ %d ] ,front  [",size,getCapacity()));
        for (int i = front; i !=tail ; i=(i+1)%data.length) {
            sb.append(i);
            if((i+1)%data.length!=tail){
                sb.append(",");
            }

        }
        sb.append(" ] tail");
        return sb.toString();
    }

    public static void main(String[] args){

        MyLoopQueue<Integer> queue = new MyLoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
