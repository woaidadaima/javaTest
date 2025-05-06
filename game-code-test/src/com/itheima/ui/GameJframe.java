package com.itheima.ui;

import javax.swing.*;
import java.util.Random;

public class GameJframe {

    //定义二维数组存放图片索引
    private int[][] arrList = new int[4][4];
    public GameJframe() {
        //初始化游戏窗体
        initGameJframe();


    }

    private void initGameJframe() {
        //创建窗体对像
        JFrame gameFrame = new JFrame("拼图单机版 V1.0");

        //设置游戏窗体
        gameFrame.setSize(603, 680);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.getContentPane().setLayout(null);


        //创建菜单栏对像
        JMenuBar menuBar = new JMenuBar();

        //菜单项
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        //子菜单
        JMenuItem replayItem = new JMenuItem("重新开始");
        JMenuItem exitItem = new JMenuItem("退出游戏");

        //功能菜单添加子菜单
        functionMenu.add(replayItem);
        functionMenu.add(exitItem);

        //添加菜单栏
        menuBar.add(functionMenu);
        menuBar.add(aboutMenu);
        gameFrame.setJMenuBar(menuBar);

        //打乱图片顺序
        initData(arrList);

        addImage(gameFrame);

        gameFrame.setVisible(true);
    }

    private void addImage(JFrame gameFrame) {
        for (int i = 0; i < arrList.length; i++) {
            for (int j = 0; j < arrList[i].length; j++) {
                int number = arrList[i][j];
                JLabel imageLabel = new JLabel(new ImageIcon("D:\\test project\\javaSE\\game-code-test\\image\\animal\\animal3\\"+ number+".jpg")
                );
                imageLabel.setBounds(j*105+83,i*105+134,105,105);
                gameFrame.getContentPane().add(imageLabel);
            }
        }
    }

    private void initData(int[][] arr){
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
//        int[][] arr = new int[4][4];

        //将元素添加到二维数组
        for (int i = 0; i < temp.length; i++) {
            arr[i/4][i%4] = temp[i];
        }

        //打印二维数组
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] +" ");
//            }
//            System.out.println();
//        }
    }
}
