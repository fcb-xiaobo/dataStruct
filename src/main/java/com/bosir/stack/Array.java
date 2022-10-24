package com.bosir.stack;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/14 09:49
 * @Description:
 */
public class Array<E> {

    private E[] data;
    private int size;

    //构造函数,传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
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
        //思考下index为啥不能size
        if (index < 0 || index > size || Objects.isNull(e)) {
            throw new IllegalArgumentException("index must >0  and <index or e is not null");
        }
        //判断是否需要扩容

        //查询元素,核心当前位置的元素都要向后移动一个位置,要从后移动
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index fail");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    // 获取index索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index fail");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        if (Objects.isNull(e)) {
         throw new IllegalArgumentException("data is not empty");
        }
        for (int i = 0; i < size; i++) {
            if(e.equals(data[i])){
                return true;
            }
        }
        return false;
    }
    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        if (Objects.isNull(e)) {
            throw new IllegalArgumentException("data is not empty");
        }
        for (int i = 0; i < size; i++) {
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }
    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index <0 || index>= size){
            throw new IllegalArgumentException("remove fail，index is not legal");
        }
        E tmp=data[index];
        for (int i = index+1; i <size ; i++) {
            data[i-1]=data[i];
        }
        size--;
        //最后一个元素位置空了
        data[size]=null;

        //数组缩容

        return tmp;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
          return remove(0);

    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}