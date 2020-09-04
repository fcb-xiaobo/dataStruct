package com.alibaba.stack;

/**
 * Created by 小波哥  2019/6/29 14:35
 * stack
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}

