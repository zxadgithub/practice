package com.zxa.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

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
}
