package com.bosir.stack.linklist;

import java.util.Objects;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/24 14:50
 * @Description: 试用虚拟head节点实现的链表
 */
public class MyDummyHeadLinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;


    public MyDummyHeadLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
        if (Objects.isNull(e)) {
            throw new IllegalArgumentException("待添加元素不能为空");
        }
        Node tmp = dummyHead;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(e, tmp.next);
        size++;
    }

    // 在链表头添加新的元素e

    /**
     * 1)dummyHead.next=null  直接添加
     * 2)dummyHead.next!=null
     */
    public void addFirst(E e) {
        Node tmpNode = dummyHead;
        if (tmpNode.next == null) {
            //head 不存在,直接添加
            Node head = new Node(e);
            tmpNode.next = head;
//            tmpNode.next = new Node(e, tmpNode.next);
        } else {
            //取出head节点
            Node tmpHead = tmpNode.next;
            Node currHead = new Node(e);
            tmpNode.next = currHead;
            currHead.next = tmpHead;
        }
        size++;
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(e);
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node head = dummyHead.next;
        while (head != null) {
            if (head.e.equals(e)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        Node head = dummyHead.next;
        Node parent = dummyHead;
        while (head != null) {
            if (head.e.equals(e)) {
                Node nextHead = head.next;
                parent.next = nextHead;
                break;
            }
            parent = head;
            head = head.next;
        }
        size--;

    }

    //
    public E getFirst(boolean isDelFirstNode) {
        Node head = dummyHead.next;
        if (head != null) {
            if (isDelFirstNode) {
                Node headNext = head.next;
                dummyHead.next = headNext;
                size--;
                return head.e;
            }else{
                return head.e;
            }
        } else {
            return null;

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("MyDummyHead size [ %d ]  head [", size));
        Node tmp = dummyHead.next;
        while (tmp != null) {
            sb.append(tmp.e);
            tmp = tmp.next;
            if (tmp != null) {
                sb.append(",");
            }
        }
        sb.append(" ] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyDummyHeadLinkedList dummyHeadLinkedList = new MyDummyHeadLinkedList();

        for (int i = 0; i < 10; i++) {
            dummyHeadLinkedList.addLast(i);
        }
        System.out.println(dummyHeadLinkedList);

        dummyHeadLinkedList.removeElement(5);
        System.out.println(dummyHeadLinkedList);
        dummyHeadLinkedList.removeElement(0);
        System.out.println(dummyHeadLinkedList);

    }
}