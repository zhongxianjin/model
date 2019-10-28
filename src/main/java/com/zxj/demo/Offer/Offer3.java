package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer3 {
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList result = new ArrayList();
        if (listNode == null) {
            return result;
        }
        Stack stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
