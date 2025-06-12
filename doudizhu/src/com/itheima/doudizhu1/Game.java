package com.itheima.doudizhu1;


import java.util.*;

public class Game {
    //牌集合
    static  ArrayList<Integer> list ;

    //地主三张牌
    private  TreeSet<Integer> lord;

    //玩家牌
    private  TreeSet<Integer> player1 ;
    private  TreeSet<Integer> player2;
    private  TreeSet<Integer> player3;

    //定义一个map集合用于排序
    private  static final HashMap<Integer, String> hm = new HashMap<>();

    //准备牌
    static {
        list = new ArrayList<>();
        //牌的花色
        String[] colors = {"♦", "♥", "♣", "♠"};

        //牌面
        String[] pokers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //作为对应牌得hashKey
        int seriesNum =1;
        //牌拼接成对应数字和花色
        for (String poker : pokers) {
            for (String color : colors) {
                hm.put(seriesNum, color + poker);
                list.add(seriesNum);
                seriesNum++;
            }
        }
        //添加小王和大王
        hm.put(seriesNum, "小王");
        list.add(seriesNum);
        seriesNum++;
        hm.put(seriesNum, "大王");
        list.add(seriesNum);
    }

    public Game() {
        //2.洗牌
        Collections.shuffle(list);
        //3.发牌
        send();
        //4.看牌
        looker("地主牌", lord);
        looker("玩家1", player1);
        looker("玩家2", player2);
        looker("玩家3", player3);

    }


    private void send() {
        lord= new TreeSet<>();
        player1= new TreeSet<>();
        player2= new TreeSet<>();
        player3= new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            //前三张为地主牌
            if (i < 3) {
                lord.add(list.get(i));
            } else {
                if (i % 3 == 0) {
                    player1.add(list.get(i));
                } else if (i % 3 == 1) {
                    player2.add(list.get(i));
                } else {
                    player3.add(list.get(i));
                }
            }
        }
    }


    private void looker(String player, TreeSet<Integer> list) {

        System.out.print(player + ":" + " ");
        for (Integer seriesNum : list) {
            String poker = hm.get(seriesNum);
            System.out.print(poker  + " ");
        }
        System.out.println();

    }
}
