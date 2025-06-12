package com.itheima.doudizhu2;

import java.util.*;

public class Game {
    //牌集合
    static ArrayList<String> list ;

    private ArrayList<String> lord ;
    private ArrayList<String> player1 ;
    private ArrayList<String> player2 ;
    private ArrayList<String> player3 ;
//    //定义一个map集合用于排序
    private  static final HashMap<String, Integer> hm = new HashMap<>();

    static {
        list = new ArrayList<>();

        //牌的花色
        String[] colors = {"♦", "♥", "♣", "♠"};
        int colorNum = 16;
        for (String color : colors) {
            hm.put(color, colorNum);
            colorNum++;
        }

        //牌面
        String[] pokers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int seriesNum = 11;
        for (int i = 8; i < pokers.length; i++) {
            hm.put(pokers[i], seriesNum);
            seriesNum++;
        }

        //牌拼接成对应数字和花色
        for (String poker : pokers) {
            for (String color : colors) {
                list.add(color+poker);
            }
        }
        //添加小王和大王
        list.add(" 小王");
        list.add(" 大王");
        hm.put("小王",99);
        hm.put("大王",100);
    }

    public Game(){
        System.out.println(list);
        Map.Entry[] entries = new Map.Entry[0];
        List<String> list = new ArrayList<>();  // List 是接口，ArrayList 是实现类

        Collections.shuffle(list);

        System.out.println(list);

        //3.发牌
        send();
//        //4.看牌
        looker("地主牌", lord);
        looker("玩家1", player1);
        looker("玩家2", player2);
        looker("玩家3", player3);
    }

    private void send() {
        lord= new ArrayList<>();
        player1= new ArrayList<>();
        player2= new ArrayList<>();
        player3= new ArrayList<>();
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
        System.out.println(lord);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
    }

    private void looker(String player, ArrayList<String> list) {
        //排序
        sort(list);
        System.out.print(player + ":" + " ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();

    }

    private void sort(ArrayList<String> list) {
        list.sort((o1, o2) -> {
            String color1 = o1.substring(0, 1);
//            System.out.println(color1);
            String color2 = o2.substring(0, 1);
//            System.out.println(color2);

            int value1 =  getValue(o1);
//            System.out.println(value1);
            int value2 =  getValue(o2);
//            System.out.println(value2);
            if(value1 == value2){
                //比较花色
             return  hm.get(color1) -  hm.get(color2);
            }else{
                return  value1-value2;
            }
        });
    }

    private int getValue(String obj) {
        String poker = obj.substring(1);
//        System.out.println(poker);
        if(!hm.containsKey(poker)){
            hm.put(poker, Integer.parseInt(poker));
        }
        return hm.get(poker);
    }


}
