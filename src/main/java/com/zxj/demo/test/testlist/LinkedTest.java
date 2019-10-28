package com.zxj.demo.test.testlist;

import org.junit.Test;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by upc on 2019/10/9.
 */
public class LinkedTest {
    int t;
    Node head;
    Node current;
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public void add(int value){
        if(head==null){
            head=new Node(value);
            current=head;
        }else {
            current.next=new Node(value);
            current=current.next;
        }
    }
    public void add(int value,Node current,Node head){
        if(head==null){
            head=new Node(value);
            current=head;
//            return current;
//            System.out.println(current.val);
        }else {
            current.next=new Node(value);
            current=current.next;

//            return current;
        }
    }
    public void print(Node node){
        Node temp=node;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    //方法：链表的反转
    public Node reverseList(Node head) {

        //如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node next = null; //定义当前结点的下一个结点
        Node reverseHead = null;  //反转后新链表的表头
        System.out.println("head--------------start");
        print(head);
        System.out.println("current-----------start");
        print(current);
        System.out.println("**********************");
        while (current != null) {
            next = current.next;  //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;
            System.out.println("**********");
            System.out.println("current----------1");
            print(current);
            System.out.println("reverseHead----------1");
            print(reverseHead);
            System.out.println("next----------1");
            print(next);
            current = next;   // 操作结束后，current节点后移
            System.out.println("current----------2");
            print(current);
        }

        return reverseHead;
    }
    //方法：从尾到头打印单链表
    public void reversePrint(Node head) {

        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();  //新建一个栈
        Node current = head;

        //将链表的所有结点压栈
        while (current != null) {
                stack.push(current);  //将当前结点压栈
            System.out.println("**********************");
            print(current);
            current = current.next;
        }

        //将栈中的结点打印输出即可
        while (stack.size() > 0) {
            System.out.println(stack.pop().val);  //出栈操作
        }
    }
    @Test
    public void test(){
        LinkedTest listTest=new LinkedTest();
        Node current = null;
        Node head = new Node(1);
        current=head;
        for(int i=0;i<10;i++){
            listTest.add(i,current,head);
            current=current.next;
        }
        listTest.print(head);
    }
    public static void main(String[] args){
//        LinkedTest listTest=new LinkedTest();
//        for(int i=0;i<10;i++){
//            listTest.add(i);
//        }
//        listTest.print(listTest.head);
//        java.util.LinkedList linkedList=new LinkedList();
        LinkedTest listTest=new LinkedTest();
        for(int i=0;i<10;i++){
            listTest.add(i);
        }
        Node head=listTest.head;
//        listTest.print(head);
        listTest.reversePrint(head);
//        listTest.reverseList(head);
        int i;
        listTest.t=listTest.t+3;
        System.out.println(listTest.t);
    }
}
