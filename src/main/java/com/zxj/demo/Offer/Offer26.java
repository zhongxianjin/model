package com.zxj.demo.Offer;

import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by upc on 2019/8/28.
 */
public class Offer26 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {

//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("睡了5s后打印,这是出main之外的非守护线程，这个推出后这个引用结束，jvm声明周期结束。任务管理的java/javaw.exe进程结束");
//            }
//        }).start();
//
//                System.out.println("mian线程直接打印，mian线程结束，电脑任务管理器的java/javaw.exe进程并没有结束。");
//        HashMap hashMap=new HashMap();
//        System.out.println(sub(7));
//        TreeNode t1=new TreeNode(10);
//        TreeNode t2=new TreeNode(6);
//        TreeNode t3=new TreeNode(14);
//        TreeNode t4=new TreeNode(4);
//        TreeNode t5=new TreeNode(8);
//        TreeNode t6=new TreeNode(12);
//        TreeNode t7=new TreeNode(16);
//        t1.left=t2;
//        t1.right=t3;
//        t2.left=t4;
//        t2.right=t5;
//        t3.left=t6;
//        t3.right=t7;
//        Convert(t1);
    }

    public static int sub(int n) {
        System.out.println("n:" + n);
        if (n == 1) {
            System.out.println("test1:" + n);
            return 1;
        }
        if (n == 2) {
            System.out.println("test2:" + n);
            return 2;
        }
        int result = sub(n - 1) + sub(n - 2);
        System.out.println("result:" + result);
        return result;
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    //双向链表的左边头结点和右边头节点
    static TreeNode leftHead = null;
    TreeNode rightHead = null;

    /**
     * 递归
     *
     * @param pRootOfTree
     * @return
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        System.out.println(pRootOfTree.val);
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            leftHead = pRootOfTree;
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        System.out.println("convert1:" + pRootOfTree.val);
        TreeNode pre = left;
        //while(pre!=null&&pre.right!=null){
        //    pre=pre.right;
        //}
        if (left != null) {
            leftHead.right = pRootOfTree;
            pRootOfTree.left = leftHead;
        }
        leftHead = pRootOfTree;
        TreeNode right = Convert(pRootOfTree.right);
        System.out.println("convert2:" + pRootOfTree.val);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }

    /**
     * 非递归
     *
     * @param pRootOfTree
     * @return
     */
    public static TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = pRootOfTree;
        TreeNode pre = null;
        boolean flag = true;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (flag) {
                pRootOfTree = temp;
                pre = pRootOfTree;
                flag = false;
            } else {
                pre.right = temp;
                temp.left = pre;
                pre = temp;
            }
            temp = temp.right;
        }
        return pRootOfTree;
    }
}
