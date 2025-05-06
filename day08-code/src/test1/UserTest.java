package test1;

public class UserTest {
    public static void main(String[] args) {
        User xiaoming= new User();
        User xiaoHong = new User("小红","123456","123@qq.com","男",18);
        System.out.println(xiaoHong.getAge());
        System.out.println(xiaoHong.getName());
        System.out.println(xiaoHong.getPassword());

        System.out.println(xiaoming.getAge());
        System.out.println(xiaoming.getName());

    }
}
