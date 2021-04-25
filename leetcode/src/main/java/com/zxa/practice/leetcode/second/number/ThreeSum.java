package com.zxa.practice.leetcode.second.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname ThreeSum
 * @Date 2021/4/25 8:27 下午
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int left =  i + 1,right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    ArrayList<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]); cur.add(nums[left]); cur.add(nums[right]);
                    result.add(cur);
                    left++; right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }

                } else if (nums[left] + nums[right] < target){
                    left++;
                } else if (nums[left] + nums[right] > target){
                    right--;
                }

            }
        }
        return result;
    }

}
