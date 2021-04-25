package com.zxa.practice.leetcode.first.array;

/**
 * @author zhangxinan
 * @Classname ReversePairs
 * @Date 2021/4/12 9:12 下午
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class ReversePairs {
    int count = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        ReversePairs reversePairs = new ReversePairs();
        reversePairs.reversePairs(nums);
        System.out.println(nums);
    }

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r){
            int mid = l + (r - l >> 1);
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l ,mid, r);
        }
    }

    private void merge(int[] nums, int l,int mid, int r) {
        int[] temp = new int[nums.length];
        for (int i = l; i <= r; i++) {
            temp[i] = nums[i];
        }
        int i = l, j = mid + 1, k = l;
        while (k <= r){
            if (i > mid){
                nums[k++] = temp[j++];
            } else if (j > r){
                nums[k++] = temp[i++];
            } else if (temp[i] > temp[j]){
                nums[k++] = temp[j++];
                count += mid - i + 1;
            } else {
                nums[k++] = temp[i++];
            }
        }
    }
}
