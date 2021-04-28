package com.zxa.practice.leetcode.first.tree;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangxinan
 * @Classname RightSideView
 * @Date 2021/4/28 10:17 下午
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return Lists.emptyList();
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Integer currRight = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                    currRight = poll.left.val;
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                    currRight = poll.right.val;
                }
            }
            if (currRight != null){
                res.add(currRight);
            }
        }
        return res;

    }

}
