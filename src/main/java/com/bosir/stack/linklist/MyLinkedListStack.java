package com.bosir.stack.linklist;

import com.bosir.stack.MyStack;


/**
 * @Auther: fanchengbo
 * @Date: 2022/10/25 18:13
 * @Description:使用链表实现栈
 * stack 结构是 FIFO(先进后出 first in first out)
 */
public class MyLinkedListStack<E> implements MyStack<E> {

    private MyDummyHeadLinkedList<E> dummyHeadLinkedList;

    public MyLinkedListStack(){
        dummyHeadLinkedList=new MyDummyHeadLinkedList();
    }

    @Override
    public int getSize() {
        return dummyHeadLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dummyHeadLinkedList.isEmpty();
    }

    @Override
    public void push(E e) {
       dummyHeadLinkedList.addLast(e);
    }

    @Override
    public E pop() {
        return dummyHeadLinkedList.getFirst(true);
    }

    @Override
    public E peek() {
        return dummyHeadLinkedList.getFirst(false);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(dummyHeadLinkedList);
        return res.toString();
    }
}