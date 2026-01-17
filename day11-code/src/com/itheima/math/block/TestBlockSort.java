package com.itheima.math.block;

public class TestBlockSort {
    public static void main(String[] args) {
        //分块数组
        int[] arr = {27,22,30,40,36,13,19,16,20,7,10,43,50,48};

        //对数组进行分块
       BlockSort b1 =  new BlockSort(22,40,0,4);
       BlockSort b2 =  new BlockSort(13,20,5,8);
       BlockSort b3 =  new BlockSort(7,10,9,10);
       BlockSort b4 =  new BlockSort(43,50,11,13);

       BlockSort[] b = {b1,b2,b3,b4};

       //调用方法查找对应元素索引
        int result = findByBlockSort(b,arr,50);

        System.out.println(result);

    }

    public static int findByBlockSort(BlockSort[] arr,int[] originData,int target){
        //先找出目标元素在哪一块
        int bIndex = findBlock(arr,target);
        if(bIndex == -1){
            return -1;
        }
        //在对应索引快中去查找对应元素
        for (int i = arr[bIndex].getFromIndex(); i <= arr[bIndex].getEndIndex(); i++) {
            if(target == originData[i]){
                return i;
            }
        }
        return -1;
    }

    public static int findBlock(BlockSort[] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if( target <= arr[i].getMax() && target >= arr[i].getMin()){
                return i;
            }
        }
        return -1;
    }
}
