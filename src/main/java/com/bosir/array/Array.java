package com.bosir.array;

/**
 * Created by 小波哥  2019/6/27 21:07
 */
public class Array<E> {

    public E date[];
    private int size;

    /**
     * 构造函数,指定数组的初始化大小
     *
     * @param capacity
     */
    public Array(int capacity) {
        date = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参的构造方法,指定数组的初始化大小为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量大小
     *
     * @return
     */
    public int getArrayLength() {
        return date.length;
    }

    /**
     * 获取数组的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean getArrayIsEmpty() {
        return size == 0;
    }

    /**
     * 在元素头部插入一个元素
     *
     * @param e
     */
    public void insertHeadElement(E e) {
        insertIndexElement(0, e);
    }

    public void insertTailElement(E e) {
        insertIndexElement(size, e);
    }
    /**
     * 在指定索引的位置上插入元素
     *
     * @param index
     * @param e
     */
    public void insertIndexElement(int index, E e) {

        //判断索引位置是否正确
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is fail,try again");
        }
        //判断集合是否还能添加新元素
        if (date.length == size) {
            resetArraySize(date.length * 2);
            //throw new IllegalArgumentException("Array add fail, array full ");
        }


        /**
         * 思路
         * 1.循环数组的size,size是比length>1
         * 2.指定index位置的元素都往后移动一个位置
         */
        for (int i = size - 1; i >= index; i--) {
            date[i + 1] = date[i];
        }
        //然后在原index上插入新的元素
        date[index] = e;
        // 维护 size +1
        size++;
    }

    /**
     * 获取指定索引上的元素
     *
     * @param index
     * @return
     */
    public E getIndexElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get elements fail,index fail");
        }
        return date[index];
    }

    /**
     * 更新指定index上元素
     *
     * @param index
     * @param e
     */
    public void updateIndexELement(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        date[index] = e;
    }

    /**
     * 查询数组是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean searchContainElement(int e) {

        for (int i = 0; i < size; i++) {
            if (date[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e
     * @return
     */
    public int searchElementIndex(int e) {
        for (int i = 0; i < size; i++) {
            if (date[i].equals(e)) {
                return i;
            }
        }


        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index
     * @return
     */
    public E deleteIndexElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("fail index,try again");
        }

        E result = date[index];
        /**
         * 从当前索引的下一位开始循环 直到数组的size
         *
         * note 不能=size  因为size是从1开始的 所以比索引的长度少一个
         */
        for (int i = index + 1; i < size; i++) {
            date[i - 1] = date[i];
        }
        if (size == date.length / 4 && date.length / 2 != 0) {
            resetArraySize(date.length / 2);
        }
        size--;
        return result;


    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, date.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(date[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 动态数组,根据capacity的太小设置新的数组
     *
     * @param newCapacity
     */
    private void resetArraySize(int newCapacity) {

        E[] newDate = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newDate[i] = date[i];
        }
    }
    //交换位置  父子节点交换位置
    public void swap(int childIndex, int parentIndex) {
        E tmpNode = date[childIndex];
        date[childIndex]=date[parentIndex];
        date[parentIndex]=tmpNode;
    }
}

