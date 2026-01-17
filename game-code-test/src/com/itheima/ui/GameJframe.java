package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.Random;

public class GameJframe extends JFrame implements ActionListener,KeyListener {

    //子菜单
    JMenuItem replayItem = new JMenuItem("重新开始");
    JMenuItem exitItem = new JMenuItem("退出游戏");
    JMenuItem aboutItem = new JMenuItem("关于我们");


    //定义二维数组存放图片索引
    private int[][] arrList = new int[4][4];

    //拼图基础路径
    String baseUrl = "game-code-test\\image\\animal\\animal3\\";

    //存储空白图片位置
    int x;
    int y;

    //统计步数
    private int step;

    //正确数组元素
    private final int[][] correct = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    public GameJframe() {
        //初始化游戏窗体
        initGameJframe();

        //初始化菜单栏
        initJmenu();

        //初始化打乱图片顺序
        initData();

        //初始化添加图片
        addImage();

    }

    private void initGameJframe() {

        //设置游戏窗体
        this.setSize(603, 680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);

        //监听键盘按下事件
        this.addKeyListener(this);

        //设置窗体可见
        this.setVisible(true);
    }

    private void initJmenu() {

        //创建菜单栏对像
        JMenuBar menuBar = new JMenuBar();

        //菜单项
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于");

        //监听menuItem事件
        replayItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);

        //功能菜单添加子菜单
        functionMenu.add(replayItem);
        functionMenu.add(exitItem);

        //关于我们菜单添加
        aboutMenu.add(aboutItem);

        //添加菜单栏
        menuBar.add(functionMenu);
        menuBar.add(aboutMenu);
        this.setJMenuBar(menuBar);
    }

    private void addImage() {

        //先清除之前组件
        this.getContentPane().removeAll();

        //判断是否通关
        if (victory()) {
            //添加通过背景
            JLabel victoryLabel = new JLabel(new ImageIcon("game-code-test/image/win.png"));
            victoryLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(victoryLabel);
        }

        //添加统计步数组件
        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < arrList.length; i++) {
            for (int j = 0; j < arrList[i].length; j++) {
                int number = arrList[i][j];
                JLabel imageLabel = new JLabel(new ImageIcon(baseUrl + number + ".jpg")
                );
                imageLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                imageLabel.setBorder(BorderFactory.createLoweredBevelBorder());
                this.getContentPane().add(imageLabel);
            }
        }

        //添加背景图片
        JLabel backgroundLabel = new JLabel(new ImageIcon("game-code-test/image/background.png"));
        backgroundLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(backgroundLabel);


        this.getContentPane().repaint();
    }

    private void initData() {
        //打乱一维数组
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random r = new Random();

        for (int i = 0; i < temp.length; i++) {
            int rNum = r.nextInt(16);
            int tempNum = temp[i];
            temp[i] = temp[rNum];
            temp[rNum] = tempNum;
        }

        //将元素添加到二维数组
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            arrList[i / 4][i % 4] = temp[i];
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (victory()) {
            return;
        }

        if (e.getKeyCode() == 65) {
            this.getContentPane().removeAll();
            JLabel fullImageLabel = new JLabel(new ImageIcon("game-code-test/image/animal/animal3/all.jpg"));
            fullImageLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(fullImageLabel);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //胜利以后不能在移动
        if (victory()) {
            return;
        }

        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        if (keyCode == 37) {
            System.out.println("向左");
            //处理边界情况
            if (y == 3) {
                return;
            }
            //交换空白图片和下方图片位置
            int temp = arrList[x][y];
            arrList[x][y] = arrList[x][y + 1];
            arrList[x][y + 1] = temp;
            //交换完更新空白图片位置
            y++;
            step++;
            addImage();
        } else if (keyCode == 38) {
            System.out.println("向上");
            //处理边界情况
            if (x == 3) {
                return;
            }
            //交换空白图片和下方图片位置
            int temp = arrList[x][y];
            arrList[x][y] = arrList[x + 1][y];
            arrList[x + 1][y] = temp;
            //交换完更新空白图片位置
            x++;
            step++;
            addImage();

        } else if (keyCode == 39) {
            System.out.println("向右");
            //处理边界情况
            if (y == 0) {
                return;
            }
            //交换空白图片和下方图片位置
            int temp = arrList[x][y];
            arrList[x][y] = arrList[x][y - 1];
            arrList[x][y - 1] = temp;
            //交换完更新空白图片位置
            y--;
            step++;
            addImage();
        } else if (keyCode == 40) {
            System.out.println("向下");
            //处理边界情况
            if (x == 0) {
                return;
            }
            //交换空白图片和下方图片位置
            int temp = arrList[x][y];
            arrList[x][y] = arrList[x - 1][y];
            arrList[x - 1][y] = temp;
            //交换完更新空白图片位置
            x--;
            step++;
            addImage();
        } else if (keyCode == 65) {
            //松开A键返回原来拼图界面
            addImage();
        } else if (keyCode == 87) {
            //一键胜利
            for (int i = 0; i < arrList.length; i++) {
                for (int j = 0; j < arrList[i].length; j++) {
                    arrList[i][j] = correct[i][j];
                }
            }
            addImage();
        }
    }

    public boolean victory() {
        //判断数组元素是否按顺序
        for (int i = 0; i < arrList.length; i++) {
            for (int j = 0; j < arrList[i].length; j++) {
                if (arrList[i][j] != correct[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == replayItem){
            step = 0;
            initData();
            addImage();
        } else if (source == exitItem) {
            System.exit(0);
        }else if (source == aboutItem) {
            JDialog aboutDialog = new JDialog(this,true);
            JLabel aboutLabel = new JLabel(new ImageIcon("game-code-test/image/girl/girl1/all.jpg"));
            aboutLabel.setBounds(0,0,258,258);
            aboutDialog.setSize(344,344);
            aboutDialog.setAlwaysOnTop(true);
            aboutDialog.getContentPane().add(aboutLabel);
            aboutDialog.setLocationRelativeTo(null);
            aboutDialog.setVisible(true);
        }
    }

}
