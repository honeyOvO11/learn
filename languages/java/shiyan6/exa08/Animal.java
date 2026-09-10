package shiyan6.exa08;

/**
 * super 关键字
 * 可以访问父类的成员
 * 格式：
 * 1.使用父类的成员变量：super.成员变量
 * 2.使用父类的成员方法：super.成员方法([参数 1,参数 2...])
 * 3.调用父类的构造方法：super([参数 1,参数 2...])
 */
public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sing() {
        System.out.println("动物会唱");
    }

    public void rap() {
        System.out.println("动物会rap");
    }
}
