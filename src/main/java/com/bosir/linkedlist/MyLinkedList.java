package com.bosir.linkedlist;

public class MyLinkedList<E> {

    private class Node{
        public E e;
        public Node next;


        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
           this(e,null);
        }

        public Node(){
            this(null,null);
        }
    }

    private Node head;
    private int size;

    public MyLinkedList(){
        head=null;
        size=0;
    }
    // 获取链表中的元素个数

    // 返回链表是否为空




}
