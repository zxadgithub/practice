package com.zxa.practice.leetcode.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname ThreeSum
 * @Date 2021/4/21 9:33 下午
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 1; j++) {
                int b = nums[j];
                if (j > i + 1 && b == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < length; k++) {
                    int c = nums[k];
                    if (k > j + 1 && c == nums[k - 1]) {
                        continue;
                    }
                    if (c == - (a + b)){
                        List<Integer> list = new ArrayList();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

}
