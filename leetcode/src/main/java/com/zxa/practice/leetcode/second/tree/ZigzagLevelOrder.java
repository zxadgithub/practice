package com.zxa.practice.leetcode.second.tree;

import com.zxa.practice.leetcode.first.tree.TreeNode;
import lombok.val;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname a
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/25 9:47 下午
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder0(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean flag = true;
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = nodeQueue.poll();
                if (flag) {
                    levelList.offerLast(temp.val);
                } else {
                    levelList.offerFirst(temp.val);
                }
                if (temp.left != null) {
                    nodeQueue.offer(temp.left);

                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                }
            }
            flag = !flag;
            result.add(new ArrayList<Integer>(levelList));
        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        result.add(new ArrayList<Integer>() {{
            add(root.val);
        }});
        boolean flag = true;
        while (!stack.isEmpty()) {
            LinkedList<Integer> queue = new LinkedList<>();
            ;
            for (int i = 0; i < stack.size(); i++) {
                TreeNode temp = stack.poll();
                if (temp.left != null) {
                    stack.add(temp.left);
                    if (flag) {
                        queue.addFirst(temp.left.val);
                    } else {
                        queue.addLast(temp.left.val);
                    }
                }
                if (temp.right != null) {
                    stack.add(temp.right);
                    if (flag) {
                        queue.addFirst(temp.right.val);
                    } else {
                        queue.addLast(temp.right.val);
                    }
                }
            }
            flag = !flag;
            if (!queue.isEmpty()) {
                result.add(new ArrayList<Integer>(queue));
            }

        }
        return result;

    }
}