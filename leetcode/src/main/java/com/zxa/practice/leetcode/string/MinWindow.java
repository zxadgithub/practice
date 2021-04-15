package com.zxa.practice.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname MinWindow
 * @Date 2021/4/14 9:21 下午
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {

    public static final String BLANK = " ";

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("aBbaBBBBA", "BBA"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> tempList = new ArrayList<>();
        ;
        List<Character> result = new ArrayList<>();
        ;

        int i = 0, end = 0;
        for (; end < s.length(); i++) {
            if (checkContains(tempList, map)) {
                while (checkContains(tempList, map)) {
                    if (result.size() == 0 || result.size() > tempList.size()) {
                        result = new ArrayList<>(tempList);
                    }
                    tempList.remove(0);
                    i = end;
                }
                end = i + 1;
            } else {
                if (i  == s.length()){
                    break;
                }
                tempList.add(s.charAt(i));
                end = i;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : result) {
            builder.append(character);
        }
        return builder.toString();
    }

    private boolean checkContains(List<Character> tempList, Map<Character, Integer> map) {
        if (!tempList.containsAll(map.keySet())) {
            return false;
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() != 1) {
                int i = 0;
                for (Character s : tempList) {
                    if (s.equals(characterIntegerEntry.getKey())) {
                        i++;
                    }
                }
                if (i < characterIntegerEntry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
