package com.alibaba.array;

/**
 * Created by 小波哥  2019/6/27 21:07
 * 数组测试主类
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array();


        for (int i = 0; i < 10; i++) {
            array.insertHeadElement(i);
        }
        System.out.println(array);


        Object i = array.deleteIndexElement(0);
        System.out.println(i);


        System.out.println("========="+array);


        System.out.println("-------------------------");



    }
}

