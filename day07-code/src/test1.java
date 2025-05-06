import java.util.Random;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        //随机产生中将号码
        int[] luckNum = generateNum();
        for (int i = 0; i < luckNum.length; i++) {
            System.out.print(luckNum[i]+ " ");
        }
        System.out.println();
        System.out.println("===============");
        //获取用户输入号码
        int[] userInputNum = getUserInput();
        //输出用户输入号码
        for (int i = 0; i < userInputNum.length; i++) {
            System.out.print(userInputNum[i]+" ");
        }
        System.out.println();
        System.out.println("==============");
        //匹配中将号码
        int redNum = 0;
        int blueNum =0;
        for (int i = 0; i < userInputNum.length-1; i++) {
            for (int j = 0; j < luckNum.length-1; j++) {
                if(userInputNum[i] == luckNum[j]){
                    //找到红球个数加1
                    redNum++;
                    break;
                }
            }
        }
        //匹配蓝球
        if(userInputNum[userInputNum.length-1] ==luckNum[luckNum.length-1]){
            blueNum = 1;
        }
        System.out.println("红球数"+redNum);
        System.out.println("蓝球数"+blueNum);

        //
        if(redNum ==6 && blueNum ==1){
            System.out.println("一等奖");
        }else if (redNum ==6 && blueNum ==0){
            System.out.println("二等奖");
        }else if (redNum ==5 && blueNum ==1){
            System.out.println("三等奖");
        }else if (redNum ==5 && blueNum ==0 || redNum ==4 && blueNum ==1){
            System.out.println("四等奖");
        }else if (redNum ==4 && blueNum ==0 || redNum ==3 && blueNum ==1){
            System.out.println("五等奖");
        }else if (redNum ==2 && blueNum ==1 || redNum ==1 && blueNum ==1 ||redNum ==0 && blueNum ==1){
            System.out.println("六等奖");
        }else{
            System.out.println("谢谢参与");
        }
    }

    public static int[] generateNum() {
        //1.随机产生6个红球，1个蓝球，6个红球号码不能相同
        int[] num = new int[7];
        Random r = new Random();
        //产生6个红球
        for (int i = 0; i < num.length - 1; ) {
            boolean flag = false;
            int rNum = r.nextInt(33) + 1;
            //判断是否重复
            boolean isExist = contain(num,rNum);
            if (!isExist) {
                num[i] = rNum;
                i++;
            }
        }
        //产生一个蓝球
        num[num.length - 1] = r.nextInt(16) + 1;
        return num;
    }

    public static int[] getUserInput() {
        //键盘获取用户输入，6个红球范围1-33，1个蓝球范围1-16，重复或者输入不在范围提示输入错误
        int[] num = new int[7];
        Scanner sc = new Scanner(System.in);
        //先输入红球
        for (int i = 0; i <num.length-1 ;) {
            System.out.println("请输入第"+(i+1)+"个红球");
            int inputNum =  sc.nextInt();
            if(inputNum >=1 && inputNum<=33){
               boolean isExist = contain(num,inputNum);
               if(isExist){
                   System.out.println("输入号码已经存在，请重新输入第"+(i+1)+"个号码");
               }else{
                   num[i] = inputNum;
                   i++;
               }
            }else{
                System.out.println("输入不在范围内，请重新输入第"+(i+1)+"个号码");
            }
        }
        //输入蓝球
        System.out.println("请输入蓝球号码");
        int blueNum = sc.nextInt();
        while (blueNum<1 || blueNum>16){
            System.out.println("输入不在范围内，请重新输入蓝球号码");
            blueNum = sc.nextInt();
        }
        num[num.length-1] = blueNum;
        return num;
    }

    public static boolean contain(int[]arr,int num) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
