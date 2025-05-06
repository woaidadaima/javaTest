package test1;

public class HeroTest {
    public static void main(String[] args) {
        Hero qiaoFeng = new Hero("乔峰",100);
        Hero jiuMoZhi = new Hero("鸠摩智",100);
        int remainHp = 100;
        while (remainHp>0){
            remainHp = jiuMoZhi.getHurt(qiaoFeng.getName());
            remainHp = qiaoFeng.getHurt(jiuMoZhi.getName());
        }

    }
}
