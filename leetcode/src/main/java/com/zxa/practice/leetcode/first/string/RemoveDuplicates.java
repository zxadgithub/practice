package com.zxa.practice.leetcode.first.string;

import java.util.Stack;
import java.util.concurrent.Future;

/**
 * @author zhangxinan
 * @Classname s
 * @Date 2021/4/24 8:58 下午
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (!stack.isEmpty()) {

                Character top = stack.peek();
                if (top == c) {
                    stack.pop();
                }else{
                    stack.push(c);
                }
            } else{
                stack.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Character c : stack) {
            res.append(c.toString());
        }
        return res.toString();


    }
}