package shiyan6.exa03;

/**
 * this 关键字：
 * 1.可以区分局部变量和成员变量同名的问题
 * 2.代表的是当前对象的引用。谁来调用我，我就代表谁。
 * 3.在构造方法中可以调用本类中其他构造方法 this（参数），必须放在第一行
 * 4.在成员方法中调用其他成员方法 this.方法名（），this 可以省掉不写。
 */
public class Animal {
    int age;
    String name;

    public Animal() {
        this(6, "tiger");
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void eat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
    }
}
