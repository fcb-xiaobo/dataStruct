package com.alibaba.linkedlist;

/**
 * Created by 小波哥  2019/7/2 20:31
 */
public class LinkedList<E> {


   private class Node{
       private Node next;
       private E e;

       public Node(Node next,E e){
           this.e=e;
           this.next=next;
       }
       public Node(E e){
           this(null,e);
       }
       public Node(){
           this(null,null);
       }
       @Override
       public String toString(){
           return e.toString();
       }
   }


}





