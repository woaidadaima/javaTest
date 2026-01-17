package com.itheima.math;

public class BubbleSort {
    public static void main(String[] args) {
         /*
            1.对数组相邻元素两两进行比较，如果前面一个大于后面一个数字，则交换位置，否则不动，继续往后比较
            2.比较完一轮以后,第二轮比较只需要从0到arr.length-1,第i轮的话arr.length-i,一共需要比较arr.length-1轮
            12435
            12345
         **/
        int[] arr = {5,4,3,2,1};

        int[] sortArr = bubbleSort(arr);

        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length -i; j++) {
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    System.out.println();
                }
            }
        }
        return arr;
    }
}
