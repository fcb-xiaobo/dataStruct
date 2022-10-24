package com.bosir.stack;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/14 10:27
 * @Description:
 */
public interface MyStack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();


}