package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer55 {
    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)
            return null;
        ListNode like=hasCycle(pHead);
        ListNode current=like;
        if(like!=null){
            int length=0;
            while(current!=null){
                current=current.next;
                length++;
                if(current==like)break;
            }
            ListNode first=pHead;
            ListNode second=pHead;
            while(length>0){
                second=second.next;
                length--;
            }
            while(first!=second){
                first=first.next;
                second=second.next;
                if(first==second)return first;
            }
            return first;

        }else{
            return null;
        }

    }
    public ListNode hasCycle(ListNode pHead){
        if(pHead==null)
            return null;
        ListNode first=pHead;
        ListNode second=pHead;
        while(second.next!=null){
            first=first.next;
            second=second.next.next;
            if(first==second){
                return first;
            }
        }
        return null;
    }
}
