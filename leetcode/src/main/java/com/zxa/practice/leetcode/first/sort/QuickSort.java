package com.zxa.practice.leetcode.first.sort;

/**
 * @author zhangxinan
 * @Classname QuckSort
 * @Date 2021/3/13 5:33 下午
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] integers = {2,2,3,4,6,1,2,67};
        quickSort(integers, 0, integers.length - 1);
        System.out.println(integers);
    }


    public static void quickSort(Integer[] array, int l ,int r){
        if (l >= r){
            return;
        }
        int partition = partition(array, l, r);
        quickSort(array, l, partition - 1);
        quickSort(array, partition + 1, r);


    }

    public static int partition(Integer[] array, int l, int r) {
        int p = array[l];
        int i = l, j =  r + 1;
        while (true) {

            while (i < r && array[++i] <= p ){
            }
            while (j > l && array[--j] >= p){
            }
            if ((i >= j)) {
                break;
            }

            swap(array, i, j);
        }
        swap(array, l, j);
        return j;
    }

    private static void swap(Integer[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

}
