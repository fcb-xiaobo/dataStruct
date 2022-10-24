package com.bosir.queue;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/14 15:14
 * @Description: 自定义队列
 */
public interface MyQueue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}