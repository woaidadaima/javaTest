package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //打乱一维数组
        int[] temp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Random r = new Random();

        for (int i = 0; i < temp.length; i++) {
           int rNum =  r.nextInt(16);
            int tempNum = temp[i];
            temp[i] = temp[rNum];
            temp[rNum] = tempNum;
        }

        //创建二维数组
        int[][] arr = new int[4][4];

        //将元素添加到二维数组
        for (int i = 0; i < temp.length; i++) {
            arr[i/4][i%4] = temp[i];
        }

        //打印二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
