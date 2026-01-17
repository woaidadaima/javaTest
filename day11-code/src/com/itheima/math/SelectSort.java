package com.itheima.math;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};

        //内循环索引从0开始一次往后比较，小的再前大的再后
        //一共比较arr.length -1 轮
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
