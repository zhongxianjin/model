package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer59 {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        int layer = 1;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode root = stack1.pop();
                    temp.add(root.val);
                    if (root.left != null) stack2.push(root.left);
                    if (root.right != null) stack2.push(root.right);
                }
                result.add(temp);
                layer++;
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode root = stack2.pop();
                    temp.add(root.val);
                    if (root.right != null) stack1.push(root.right);
                    if (root.left != null) stack1.push(root.left);
                }
                result.add(temp);
                layer++;
            }
        }
        return result;
    }
}
