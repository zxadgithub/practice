package com.zxa.practice.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxinan
 * @Classname LengthOfLongestSubstring
 * @Date 2021/3/17 10:09 下午
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 滑动窗口维护start, end
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        int length = s.length();
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>(length / 2);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                start = Math.max(map.get(c) + 1, start);
            }
            max = Math.max(i - start + 1, max);
            map.put(c, i);
        }
        return max;
    }
}
