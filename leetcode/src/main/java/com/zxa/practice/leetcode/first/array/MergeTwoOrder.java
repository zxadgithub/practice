package com.zxa.practice.leetcode.first.array;

/**
 * @author zhangxinan
 * @Classname MergeTwoOrder
 * @Date 2021/3/14 5:07 下午
 */
public class MergeTwoOrder {

    public static void main(String[] args) {
        int[] a = {2,0};
        int[] b = {1};
        merge1(a, 1,b,1);
        System.out.println(a);
    }



    /**
     * 双指针 从后往前
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p2 >= 0){
            if (p1 >= 0 && nums1[p1] >= nums2[p2]){
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int index = 0;
        int[] res = new int[m+n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                res[index] = nums1[i];
                i++;
            } else {
                res[index] = nums2[j];
                j++;
            }
            index++;
        }
        if(i == m){
            for(int h = j; h<n;h++){
                res[index++] = nums2[j++];
            }
        } else{
            for(int h = i; h<m;h++){
                res[index++] = nums1[i++];
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = res[k];
        }
    }

}
