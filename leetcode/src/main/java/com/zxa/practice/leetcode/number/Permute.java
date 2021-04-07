package com.zxa.practice.leetcode.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname Permute
 * @Date 2021/3/28 6:30 下午
 */
public class Permute {


    public List<List<Integer>> permute1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> option = new ArrayList<>();
        backTrace(nums, option, res);
        return res;
    }

    private void backTrace(int[] nums, List<Integer> option, List<List<Integer>> res) {
        if (nums.length == option.size()){
            res.add(new ArrayList<>(option));
        }
        for (int i = 0; i < nums.length; i++) {
            if (option.contains(nums[i])){
                continue;
            }
            option.add(nums[i]);
            backTrace(nums, option, res);
            option.remove(option.size() - 1);
        }
    }


    // error
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);
            int j = i;
            while (true){
                j++;
                if (j >= nums.length){
                    j = 0;
                }
                if (j == i){
                    break;
                }
                cur.add(nums[j]);
            }
            res.add(cur);
        }
        return res;
    }
}
