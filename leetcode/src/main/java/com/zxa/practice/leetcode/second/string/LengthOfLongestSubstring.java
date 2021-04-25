package com.zxa.practice.leetcode.second.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname l
 * @Date 2021/4/25 7:53 下午
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abeafabc"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int start = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        ;
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i);

        }
        return max;
    }
}