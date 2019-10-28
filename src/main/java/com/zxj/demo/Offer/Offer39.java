package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer39 {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
