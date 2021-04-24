package com.zxa.practice.leetcode.tree;

/**
 * @author zhangxinan
 * @Classname a
 * @Date 2021/4/24 5:54 下午
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class DiameterOfBinaryTree {
    int res;

    /**
     * max(当前节点左右子数节点数 + 1)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        depth(root);
        return res - 1;
    }

    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }
}