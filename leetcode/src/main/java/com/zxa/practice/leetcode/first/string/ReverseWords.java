package com.zxa.practice.leetcode.first.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangxinan
 * @Classname e
 * @Date 2021/3/17 9:14 下午
 */
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        String temp = "";
        if (words.length == 1){
            return words[0];
        }

        int r = words.length - 1;
        int l = 0;
        while (r >= l){
            temp = words[r];
            words[r] = words[l];
            words[l] = temp;
            r--;
            l++;
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")){
                continue;
            }
            res.append(words[i]);

            if (words.length - 1 != i){
                res.append(" ");
            }

        }
        return res.toString();

    }
}
