package com.zxa.practice.leetcode.first.tree;

/**
 * @author zhangxinan
 * @Classname tr
 * @Date 2021/3/25 9:36 下午
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
