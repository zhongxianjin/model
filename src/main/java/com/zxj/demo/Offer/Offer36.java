package com.zxj.demo.Offer;

import java.util.HashMap;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer36 {
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        int len1 = getLinkLength(current1);
        int len2 = getLinkLength(current2);
        if (len1 > len2) {
            int i = len1 - len2;
            while (i > 0) {
                current1 = current1.next;
                i--;
            }
        } else if (len1 < len2) {
            int i = len2 - len1;
            while (i > 0) {
                current2 = current2.next;
                i--;
            }
        }
        while (current1 != null) {
            if (current1 == current2) {
                break;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;
    }

    public int getLinkLength(ListNode current) {
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * hashMap方法
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        HashMap<ListNode,Object> map=new HashMap<>();
        while(pHead1!=null){
            map.put(pHead1,null);
            pHead1=pHead1.next;
        }
        while(pHead2!=null){
            if(map.containsKey(pHead2)){
                return pHead2;
            }
            pHead2=pHead2.next;
        }
        return pHead2;
    }
}
