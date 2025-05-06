package test1;

import java.util.Random;

public class Hero {
    private String name;
    private int hp;

    public Hero() {
    }

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * 设置
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHurt(String attacker){
        Random r = new Random();
        int num = r.nextInt(100);
        this.hp = this.hp -num;
        System.out.println(attacker + "举起拳头打了"+this.name+"一下，造成了"+ num+"点伤害，"+this.name+"还剩下"+this.hp+"点血。");
        if(this.hp<=0){
            System.out.println(attacker+"K.O.了"+this.name);
        }
        return this.hp;
    }
}
