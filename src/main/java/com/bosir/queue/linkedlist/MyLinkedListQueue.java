package com.bosir.queue.linkedlist;

import com.bosir.queue.MyQueue;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/26 13:39
 * @Description:基于链表实现的队列 队列是FIFO 先进先出
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {


    private class Node {
        private E e;
        private Node next;


        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node head, tail;
    private int size;


    public MyLinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        Node delNode = this.head;
        head = delNode.next;
        delNode.next=null;
        //判断这个 是因为如果队列只剩下一个元素
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (head == null) {
            return null;
        } else {
            return head.e;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
//        sb.append(String.format("queue size  %d  , head  %d  ,tail  %d ",size,head,tail));
        sb.append(" queue 元素 [");
        Node tmp = this.head;
        while (tmp!=null){
            sb.append(tmp +" => ");
            tmp=tmp.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedListQueue linkedListQueue=new MyLinkedListQueue();
        for (int i = 1; i <= 10; i++) {
            linkedListQueue.enqueue(i);
            if(i%3==0){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);

            }
        }
        System.out.println(linkedListQueue);
    }
}