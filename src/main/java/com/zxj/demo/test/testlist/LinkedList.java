package com.zxj.demo.test.testlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by upc on 2019/7/20.
 */
public class LinkedList {
    public Node head;
    public Node currentIndex;

    public LinkedList() {
        for (int i = 0; i < 9; i++) {
            this.add(i);
        }
        this.print(this.head);
        System.out.println("print current");
        this.print(this.currentIndex);
        for (int i=10;i<15;i++){
            this.add(i);
        }
        System.out.println("*******************************************");
//        String[] array=new String[10];
        ArrayList arrayList = this.address(this.head);
        reverse(arrayList);
        System.out.println("*******************************************");
        reverseStatc(arrayList);
        System.out.println("*******************************************");
        intervalInsertion(arrayList);
    }

    /**
     * 单链表的创建和遍历
     *
     * @param args
     */

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

    }

    /**
     * 内部类，单向链表
     */
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 增加节点
     *
     * @param data
     */

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            currentIndex = head;
            System.out.println("head="+currentIndex.data);
        } else {
            currentIndex.next = new Node(data);
            currentIndex = currentIndex.next;
            System.out.println("head="+currentIndex.data);
        }
    }

    /**
     * 遍历链表
     *
     * @param node
     */
    public void print(Node node) {
        if (node == null) {
            return;
        }
       Node currentIndex = node;
        while (currentIndex != null) {
            System.out.println(currentIndex.data);
            currentIndex = currentIndex.next;
        }
    }

    /**
     * 链表存储返回链表地址
     *
     * @param node
     * @return
     */
    public ArrayList address(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        currentIndex = node;
        while (currentIndex != null) {
            arrayList.add(currentIndex);
            currentIndex = currentIndex.next;
        }
        return arrayList;
    }

    /**
     * 链表反转
     *
     * @param arrayList
     */
    public void reverse(ArrayList<Node> arrayList) {
        Node node;
        Node node1 = new Node((arrayList.get(arrayList.size() - 1)).data);
        node = node1;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            node.next = new Node((arrayList.get(arrayList.size() - 2 - i)).data);
            node = node.next;
        }
        this.print(node1);
    }

    /**
     * 链表反转(通过栈）
     *
     * @param arrayList
     */
    public void reverseStatc(ArrayList arrayList) {

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arrayList.size(); i++) {
            stack.add(((Node) arrayList.get(i)).data);
        }
        Node node1 = new Node(stack.pop());
        Node node = node1;
        for (int i = 1; i < arrayList.size(); i++) {
            node.next = new Node(stack.pop());
            node = node.next;
        }
        this.print(node1);
    }

    /**
     * 间隔插入链表
     *
     * @param arrayList
     */
    public void intervalInsertion(ArrayList arrayList) {
        if (arrayList==null){
            return;
        }
        int len = arrayList.size();
        int half = len / 2;
        int flag = len % 2;
        Node node;
        Node node1 = new Node(((Node) arrayList.get(0)).data);
        node = node1;
        for (int i = 1, j = 0; i < half; i++, j++) {
            node.next = new Node(((Node) arrayList.get(len - 1 - j)).data);
            node = node.next;
            node.next = new Node(((Node) arrayList.get(i)).data);
            node = node.next;

        }
        if (flag == 0) {
            node.next = new Node(((Node) arrayList.get(half)).data);
            node = node.next;
        } else {
            node.next = new Node(((Node) arrayList.get(len - half)).data);
            node = node.next;
            node.next = new Node(((Node) arrayList.get(half)).data);
            node = node.next;
        }
        this.print(node1);
    }

    /**
     * 方法：获取单链表的长度
     *
     * @param head
     * @return
     */
    public int getLength(Node head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
}
