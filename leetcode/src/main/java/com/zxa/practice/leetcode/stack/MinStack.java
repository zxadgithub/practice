package com.zxa.practice.leetcode.stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname MinStack
 * @Date 2021/3/18 9:29 下午
 */
public class MinStack {

    Stack<Integer> stack = new Stack();
    Queue<Integer> queue = new PriorityQueue();


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        queue.remove(pop);

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return queue.peek();
    }
}


class MinStack1 {

    Stack<int[]> stack = new Stack();


    /** initialize your data structure here. */
    public MinStack1() {

    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.add(new int[]{val, val});
        } else {
            stack.add(new int[]{val, stack.peek()[1] > val ? val : stack.peek()[1]});
        }
    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
