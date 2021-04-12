package com.zxa.practice.leetcode.sort;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author zhangxinan
 * @Classname MergeSort
 * @Date 2021/4/11 4:37 下午
 */
public class MergeSort {
    int []temp;

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] integers = new int[]{2,3,1,4,8,2,4,1,5};
        mergeSort.sort(integers);
        System.out.println(integers);

    }

    public void sort(int[] nums){
        temp =  new int[nums.length];;
        mergeSort(nums, 0 ,nums.length - 1);
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi){
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(nums,lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge1(nums, lo,mid, hi);
    }

    private void merge1(int[] nums, int l,int mid, int r) {
        int[] temp = new int[nums.length];
        for (int i = l; i < r + 1; i++) {
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
            } else {
                nums[k++] = temp[i++];
            }
        }
    }


    private void merge(Integer[] nums, int lo,int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++){
            temp[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                nums[k] = temp[j++];
            }else  if (j > hi){
                nums[k] = temp[i++];
            }else if (temp[i] > temp[j]){
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }
    }
}
