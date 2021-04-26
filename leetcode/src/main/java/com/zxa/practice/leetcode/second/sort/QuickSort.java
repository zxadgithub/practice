package com.zxa.practice.leetcode.second.sort;

/**
 * @author zhangxinan
 * @Classname QuickSort
 * @Date 2021/4/26 7:54 上午
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = {4, 4, 2, 8, 9, 3};
        quickSort.sort(ints);
        return;
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int partition = partition(nums, l, r);
        sort(nums, 0, partition - 1);
        sort(nums, partition + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int base = nums[l];
        int i = l, j = r + 1;
        while (i < j) {
            while (nums[++i] <= base) {
                if (i == r){
                    break;
                }
            }

            while (nums[--j] >= base) {
                if (j == l){
                    break;
                }
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[j];
        nums[j] = nums[l];
        nums[l] = temp;

        return j;
    }
}
