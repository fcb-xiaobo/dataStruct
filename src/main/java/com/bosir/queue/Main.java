package com.bosir.queue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        System.out.println(String.format("队列元素 [ %s ]",queue));

        Object dequeue1 = queue.dequeue();
        Object dequeue2 = queue.dequeue();

        System.out.println(String.format("出队元素 [ %s ], [ %s ] ,出队只有数据元素 [ %s ]",dequeue1,dequeue2,queue));


        System.out.println("循环队列  执行记录------------------------------------");
        LoopQueue loopQueue=new LoopQueue();

        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);

        }

        System.out.println("循环队列 -> "+loopQueue);


    }
}
