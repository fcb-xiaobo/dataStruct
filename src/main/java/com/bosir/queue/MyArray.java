package com.bosir.queue;


import java.util.Objects;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/14 14:26
 * @Description:
 */
public class MyArray<E> {
    private E[] arrays;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public MyArray(int capacity) {
        arrays = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public MyArray() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return arrays.length;
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
        if (index < 0 || index >= size || Objects.isNull(e)) {
        }
        //判断是否需要扩容

        //从index开始,为了数组在内存连续的空间,所有每个元素都需要往后移动一个位置
        for (int i = size - 1; i >= index; i--) {
            arrays[i + 1] = arrays[i];
        }
        arrays[index] = e;
        size++;

    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size , e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {

        }
        return arrays[index];

    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size || Objects.isNull(e)) {
            throw new IllegalArgumentException("");
        }
        arrays[index] = e;

    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        if (Objects.isNull(e)) {
        }
        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        if (Objects.isNull(e)) {
        }

        for (int i = 0; i < size; i++) {
            if (arrays[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 | index >= size) {
            throw new IllegalArgumentException("");
        }
        E tmp = arrays[index];
        //从当前删除的索引向前移动
        for (int i = index + 1; i < size; i++) {
            arrays[i - 1] = arrays[i];
        }
        //判断是否缩容

        size--;

        return tmp;

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
        if (index == -1) {
            remove(index);
        }
    }
}