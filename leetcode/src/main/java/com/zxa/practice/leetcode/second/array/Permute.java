package com.zxa.practice.leetcode.second.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname Permute
 * @Date 2021/5/9 5:09 下午
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>>  permute(int[] nums){
        List<Integer> options = new ArrayList<>(nums.length);
        backTrace(nums, options);
        return res;
    }

    private void backTrace(int[] nums, List<Integer> options) {

        if (options.size() == nums.length){
            res.addAll(new ArrayList(options));
        }

        for(Integer i : nums){
            if (options.contains(i)){
                continue;
            }
            options.add(i);
            backTrace(nums, options);
            options.remove(i);
        }


    }

}
