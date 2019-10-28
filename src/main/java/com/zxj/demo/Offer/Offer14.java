package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/22.
 */
public class Offer14 {
    public static ListNode current = null;

    Offer14(ListNode head, int k) {
        ListNode result = FindKthToTail(head, k);
        print(result);
//        print(head);
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode result = head;
        ListNode temp = head;
        int i = 1;
        for (; temp != null; i++) {

            if (i > k) {
                result = result.next;
                System.out.println("i=" + i);
            }

            temp = temp.next;
        }
        if (i <= k) {
            return null;
        }
        System.out.println("****************************************");
        print(temp);
        System.out.println("****************************************");
        print(head);
        System.out.println("****************************************");
        return result;
    }

    /**
     * 添加链表值
     *
     * @param head
     * @param Val
     * @return
     */
    public static ListNode add(ListNode head, int Val) {
        if (head == null) {
            head = new ListNode(Val);
            current = head;
            return head;
        } else {

            current.next = new ListNode(Val);
            current = current.next;
            return head;
        }
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode test = head;
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode = null;
        for (int i = 0; i < 5; i++) {
            listNode = Offer14.add(listNode, i + 1);
        }
        print(listNode);
        Offer14 test = new Offer14(listNode, 5);
    }
}
