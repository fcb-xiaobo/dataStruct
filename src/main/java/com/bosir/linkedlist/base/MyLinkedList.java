package com.bosir.linkedlist.base;


/**
 * 链表
 */
public class MyLinkedList<E> {

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
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
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

    // 在链表头添加新的元素e
    public void addFirst(E e) {
//        Node node=new Node(e);
//        node.next=head;
        head = new Node(e, head);
        size++;
    }


    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）

    /**
     * 在链表末尾添加新的元素e
     * <p>
     * 核心点：链表如果为null 新增节点就是head节点,然后返回
     * <p>
     * 如果只有head节点  直接把head.next=new Node
     * <p>
     * 否则递归 找到最后一个节点 然后添加节点
     */

    public void addTail(E e) {
        if (head == null) {
            addFirst(e);
            return;
        }
        Node prev = head;
        //先找到末尾节点
        while (prev.next != null) {
            prev = prev.next;

        }
        prev.next = new Node(e);
        size++;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
//        if(head==null){
//            return false;
//        }else{
//            Node tmp=head;
//            while (tmp.next!=null){
//                if(tmp.e.equals(e)){
//                    return true;
//                }
//                tmp=tmp.next;
//
//            }
//            if(tmp.e.equals(e)){
//                return true;
//            }
//            return false;
//        }

//        // todo good code
//        Node tmp=head;
//        while (tmp!=null){
//            if(tmp.e.equals(e)){
//                return true;
//            }
//            tmp=tmp.next;
//        }
//        return false;

        //good code
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.e.equals(e)) {
                return true;
            }

        }
        return false;
    }

    /**
     * 核心  删除的元素要接着挂载起来
     * 元素 2个以内不考虑
     */
    //从链表中删除元素E
    public void removeElement(E e) {
//       //先发现元素   1,2,3  删除2
        if(head==null){
            return;
        }
        Node tmp = head;
        Node delParentNode = head;
        if (head.e.equals(e)) {
            head = head.next;
            size--;
            return;
        }

        while (tmp != null) {
            if (tmp.e.equals(e)) {
                //维护next指针
                if (tmp.next == null) {
                    //没有后续节点  直接删除
                   delParentNode.next=null;
                } else {
                    //删除的
                    //取出2的后位置 3 然后把1.next =3
                    Node delNodeNext = tmp.next;
                    delParentNode.next = delNodeNext;

                }

            }
            delParentNode = tmp;
            tmp = tmp.next;
        }


//        Node prev = head;
//        while(prev.next != null){
//            if(prev.next.e.equals(e))
//                break;
//            prev = prev.next;
//        }
//
//        if(prev.next != null){
//            Node delNode = prev.next;
//            prev.next = delNode.next;
//            delNode.next = null;
//            size --;
//        }
        size--;
        return;

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        if (head == null) {
//            sb.append("链表是empty");
//            return sb.toString();
//        } else {
//            sb.append("head ");
//            sb.append(" "+head.e);
//            Node tmp = head;
//            while (tmp.next != null) {
//                tmp=tmp.next;
//                sb.append("  "+tmp.e);
//
//            }
//            return sb.toString();
//        }
        sb.append("myLinkList: head ");
        Node tmp = head;
        while (tmp != null) {
            sb.append(tmp.e + "=>");
            tmp = tmp.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
