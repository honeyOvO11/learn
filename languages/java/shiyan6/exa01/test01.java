package shiyan6.exa01;

public class test01 {
    public static void main(String[] args) {
        Student stul = new Student();
        stul.setAge(18);
        stul.name = "xiaoming";
        System.out.println("名字：" + stul.name + "年龄：" + stul.getAge());
    }
}