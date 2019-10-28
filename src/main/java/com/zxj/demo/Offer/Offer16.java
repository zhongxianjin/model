package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/22.
 */
public class Offer16 {
    Offer16() {
        ListNode head = null;
        for (int i = 0; i < 5; i++) {
            head = add(head, i + 1);
        }
        ListNode head2=null;
        for (int i=2;i<7;i++){
            head2=add(head2,i);
        }
        print(head);
        print(head2);
        ListNode result=Merge(head,head2);
        System.out.println("**************");
//        print(head);
//        print(head2);
        print(result);
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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
            return new ListNode(val);
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
            return head;
        }
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public void print(ListNode head) {
        if (head == null)
            return;
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /**
     * 合并排序列表
     *
     * @param list1
     * @param list2
     * @return
     */

    public ListNode Merge(ListNode list1, ListNode list2) {
        System.out.println("list1");
        print(list1);
        System.out.println("list2");
        print(list2);
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null)
            return list2;
        if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        if (list1.val < list2.val) {
            result = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            result = new ListNode(list2.val);
            list2 = list2.next;
        }
        System.out.println("result");
        print(result);
        ListNode temp = result;
        System.out.println("temp");
        print(temp);
        while (list1 != null || list2 != null) {
            if(list1==null){
                temp.next=list2;
                break;
            }else if(list2==null){
                temp.next=list1;
                break;
            }else if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                temp = temp.next;
                list1 = list1.next;
            } else{
                temp.next = new ListNode(list2.val);
                temp = temp.next;
                list2 = list2.next;
            }
        }
        System.out.println("temp");
        print(temp);
        return result;
    }
    public static void main(String[] args){
        new Offer16();
    }
}
