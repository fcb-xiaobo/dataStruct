package com.bosir.stack;

import com.bosir.stack.linklist.MyLinkedListStack;

public class Main {
    public static void main(String[] args) {
        MyLinkedListStack arrayStack=new MyLinkedListStack();
        for (int i = 0; i <10 ; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);

        Object pop = arrayStack.pop();
        Object pop1 = arrayStack.pop();
        System.out.println(String.format("删除元素 [ %d ],[ %d ]",pop,pop1));
//
        System.out.println(arrayStack);



    }
}
