package com.bosir.heap;

import java.util.Arrays;

/**
 * @Auther: fanchengbo
 * @Date: 2022/11/1 13:44
 * @Description:
 */
public class MyArray<E> {

    private E[] data;
    private int size;

    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyArray() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail");
        }
        //扩容
        if (size == data.length) {
            resize(getCapacity() * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int capacity) {
        E[] tmpData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmpData[i] = data[i];
        }
        data = tmpData;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }


    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E tmpE = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return tmpE;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("myArray size [ %d] ", size));
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            //判断不是最后一个元素
            if (i != size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}