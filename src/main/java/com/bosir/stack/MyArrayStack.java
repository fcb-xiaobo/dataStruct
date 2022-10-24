package com.bosir.stack;



/**
 * @Auther: fanchengbo
 * @Date: 2022/10/14 10:27
 * @Description:
 */
public class MyArrayStack<E> implements MyStack<E> {

    private Array<E> arrays;

    public MyArrayStack(int capacity){
        arrays=new Array<>(capacity);
    }

    public MyArrayStack(){
       arrays=new Array<>();
    }

    @Override
    public int getSize() {
        return arrays.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrays.isEmpty();
    }

    @Override
    public void push(E e) {
        arrays.addLast(e);
    }

    @Override
    public E pop() {
        return arrays.removeLast();
    }

    @Override
    public E peek() {
        return arrays.getLast();
    }

    @Override
    public String toString() {
        return "MyArrayStack{" +
                "arrays=" + arrays +
                '}';
    }
}