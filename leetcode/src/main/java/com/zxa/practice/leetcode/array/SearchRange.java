package com.zxa.practice.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname SearchRange
 * @Date 2021/3/26 9:24 下午
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int i1 = findFirst(nums,target);
        if (i1 == -1) {
            return new int[]{-1, -1};
        }

        int i2 = findLast(nums,target);
        return new int[]{i1,i2};


    }

    private int findFirst(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l< r){
            int mid = l + ( (r - l ) >> 1);
            int midVal = nums[mid];
            if (midVal < target){
                l = mid + 1;
            }
            if (midVal > target){
                r = mid - 1;
            }
            if (midVal == target){
                r = mid;
            }
        }

        if (nums[l] == target) {
            return l;
        }
        return  -1;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + ( (r - l + 1) >> 1);
            int midVal = nums[mid];
            if (midVal < target){
                l = mid + 1;
            }
            if (midVal > target){
                r = mid - 1;
            }
            if (midVal == target){
                l = mid;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return  -1;
    }
}
