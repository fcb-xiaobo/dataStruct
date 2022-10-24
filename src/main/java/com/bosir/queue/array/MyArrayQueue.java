package com.bosir.queue.array;

import com.bosir.queue.MyArray;
import com.bosir.queue.MyQueue;

/**
 * @Auther: bosir
 * @Date: 2022/10/14 14:25
 * @Description:  ArrayQueue 基于数据实现的queue
 */
public class MyArrayQueue<E> implements MyQueue<E> {

    private MyArray<E> myArray;

    public MyArrayQueue(int capacity){
        myArray=new MyArray(capacity);
    }

    public MyArrayQueue(){
        myArray=new MyArray();
    }
    @Override
    public int getSize() {
        return myArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    //入队
    @Override
    public void enqueue(E e) {
        myArray.addLast(e);

    }
    //出队
    @Override
    public E dequeue() {
        return myArray.removeFirst();
    }
    //获取队首操作
    @Override
    public E getFront() {
        return myArray.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Queue : [ ");
        for (int i = 0; i < myArray.getSize(); i++) {
            sb.append(myArray.get(i));
            if(i!=myArray.getSize()-1){
                sb.append(" ->");
            }

        }
        sb.append(" ]");
        return sb.toString();
    }


    public static void main(String[] args) {

        MyArrayQueue<Integer> queue = new MyArrayQueue<>(20);
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