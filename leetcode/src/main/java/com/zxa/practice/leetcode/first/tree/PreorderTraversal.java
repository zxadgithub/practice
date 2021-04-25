package com.zxa.practice.leetcode.first.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname PreorderTraversal
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @Date 2021/3/25 9:35 下午
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        return result;
    }

    /**
     * 递归
     * @param result
     * @param root
     */
    private void preorderTraversal(final List<Integer> result, TreeNode root) {
        if (root == null){
            return;
        }
        result.add(root.val);
        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);

    }

    /**
     * 非递归
     * @param result
     * @param root
     */
    private void preorderTraversal0(final List<Integer> result, TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }
    }
}
