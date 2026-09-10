package shiyan4;

import math.ComputeMaxMin; // 导入工具类

public class Student {
    // 1. 定义5个成员变量（private修饰符保护数据）
    private String sNo; // 学号
    private String sName; // 姓名
    private String sSex; // 性别
    private int sAge; // 年龄
    private double sJava; // Java成绩
    // 2. 有参构造方法（public访问权限）

    public Student(String no, String name, String sex, int age, double javaScore) {
        this.sNo = no;
        this.sName = name;
        this.sSex = sex;
        this.sAge = age;
        this.sJava = javaScore;
    }// 3. 成员方法：获取学号

    public String getNo() {
        return sNo;
    }// 4. 成员方法：获取姓名

    public String getName() {
        return sName;
    }// 5. 成员方法：获取性别

    public String getSex() {
        return sSex;
    }// 6. 成员方法：获取年龄

    public int getAge() {
        return sAge;
    }// 7. 成员方法：获取Java成绩

    public double getJava() {
        return sJava;
    }

    public static void main(String[] args) {// 创建5个学生对象
        Student[] students = {
                new Student("001", "张三", "男", 20, 89.5),
                new Student("002", "李四", "女", 19, 92.0),
                new Student("003", "王五", "男", 21, 85.5),
                new Student("004", "赵六", "女", 20, 94.5),
                new Student("005", "陈七", "男", 22, 88.0)
        };

        // 提取Java成绩到数组
        double[] javaScores = new double[students.length];
        for (int i = 0; i < students.length; i++) {
            javaScores[i] = students[i].getJava();
        }

        // 创建ComputeMaxMin对象
        ComputeMaxMin calculator = new ComputeMaxMin(javaScores);

        // 输出结果
        System.out.println("Java成绩最高分: " + calculator.max());
        System.out.println("Java成绩最低分: " + calculator.min());
    }
}