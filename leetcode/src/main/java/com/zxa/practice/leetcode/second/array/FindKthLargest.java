package com.zxa.practice.leetcode.second.array;

/**
 * @author zhangxinan
 * @Classname findKthLargest
 * @Date 2021/4/26 10:06 下午
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        findKthLargest.findKthLargest(new int[]{1}, 1);
    }

    public int findKthLargest(int[] nums, int k) {
        return topK(nums, 0, nums.length - 1, nums.length - k);
    }

    private int topK(int[] nums, int l, int r, int k) {
        int index = partition(nums, l, r);
        if (index == k){
            return nums[index];
        }
        if (index > k){
            return topK(nums, l, index - 1, k);
        } else {
            return topK(nums,  index + 1,r, k);
        }

    }

    private int partition(int[] nums, int l, int r) {
        int p = nums[l];
        int i = l, j = r + 1;
        while (true){
            while (i < r && nums[++i] <= p ){
            }
            while (j > l && nums[--j] >= p){
            }

            if (i >= j){
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[l];
        nums[l] = nums[j];
        nums[j] = temp;
        return j;
    }
}
