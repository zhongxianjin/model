package com.zxj.demo.Offer;

import java.util.Stack;

/**
 * Created by upc on 2019/8/22.
 */
public class Offer15 {
    public ListNode current = null;

    Offer15() {
        ListNode head = null;
        for (int i = 0; i < 5; i++) {
            head = add(head, i + 1);
        }
        print(head);
        head = ReverseList(head);
        System.out.println("******************************");
        print(head);
        for (int i=5;i<10;i++){
            head=add(head,i+1);
        }
        System.out.println("******************************");
        print(head);
        print(current);
    }

    /**
     * 添加链表
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode add(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
            current = head;
            return head;
        } else {
            current.next = new ListNode(val);
            System.out.println("add:"+current.val);
            current = current.next;
            return head;
        }
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode result = new ListNode(stack.pop());
        ListNode temp = result;
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return result;
    }
    public static void main(String[] args){
        new Offer15();
    }
}
