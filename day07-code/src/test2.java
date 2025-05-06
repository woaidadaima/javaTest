public class test2 {
    public static void main(String[] args) {
        int[][] arr = {
                {22,66,44},
                {77,33,88},
                {25,45,65},
                {11,66,99}
        };
        int total =0;
        for (int i = 0; i < arr.length; i++) {
            int seasonSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                seasonSum += arr[i][j];
            }
            System.out.println("第一季度总营业额"+seasonSum);
            total += seasonSum;
        }
        System.out.println("总营业额"+total);
    }
}
