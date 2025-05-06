package test2;

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        Student s1 = new Student(1, "李四", 25);
        Student s2 = new Student(2, "王五", 26);
        Student s3 = new Student(3, "老六", 27);
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
//        //新建一个学生对像
//        Student s4 = new Student(4, "老七", 28);
//        //添加前进行唯一性判断
//        boolean flag = contains(students, s4);
//        if (!flag) {
//            //判断当前数组有几个元素
//            int count = calArrayLength(students);
//            if (count == students.length) {
//                //数组长度已满，需要生成新手组去添加
//                Student[] newArr = creatNewArray(students);
//                newArr[count] = s4;
//                printArr(newArr);
//            } else {
//                //直接添加
//                students[count] = s4;
//                printArr(students);
//            }
//        } else {
//            System.out.println("该学生对像已存在，请重新添加");
//        }

//        System.out.println("删除");
//        int index = getIndex(students,1);
//        if(index >= 0){
//            students[index] = null;
//            printArr(students);
//        }else{
//            System.out.println("删除失败");
//        }

        int index2 = getIndex(students,3);
        if(index2>=0){
         int newAge =  students[index2].getAge() + 1;
         students[index2].setAge(newAge);
         printArr(students);
        }else {
            System.out.println("修改失败");
        }
    }

    //获取数组对应id的索引
    public static int getIndex(Student[] students, int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }

    //遍历学生信息
    public static void printArr(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if(students[i]!=null){
                System.out.println("学号:" + students[i].getId() + "," + "姓名:" + students[i].getName() + "," + "年龄" + students[i].getAge());
            }
        }
    }

    //创建新数组
    public static Student[] creatNewArray(Student[] students) {
        Student[] newArray = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }
        return newArray;
    }

    //判断当前数组有几个元素
    public static int calArrayLength(Student[] students) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                count++;
            }
        }
        return count;
    }

    //判断是否已存在Id
    public static boolean contains(Student[] students, Student person) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == person.getId()) {
                    return true;
                }
            }
        }
        return false;
    }
}
