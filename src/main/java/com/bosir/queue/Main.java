package com.bosir.queue;

import com.bosir.queue.array.MyArrayQueue;
import com.bosir.queue.loop.MyLoopQueue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int opCount = 100000;

        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>(opCount);
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>(opCount);
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");


    }

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(MyQueue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
