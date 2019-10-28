package com.zxj.demo.Offer;

import java.util.Stack;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int count = 0;

    /**
     * 递归
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode root = KthNode(pRoot.left, k);
            if (root != null) return root;
            count++;
            if (k == count)
                return pRoot;
            root = KthNode(pRoot.right, k);
            if (root != null) return root;
        }
        return null;
    }

    /**
     * 栈
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null) return pRoot;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                count++;
                if (count == k) return temp;
                pRoot = temp.right;
            }
        }
        return null;
    }

}
