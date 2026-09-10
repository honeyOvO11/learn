package shiyan6.exa02;

/**
 * 构造方法的定义格式：
 * 权限修饰符方法名()方法体；
 * 1.方法名和类名要保持一致
 * 2.构造方法没有返回值类型，连void 都不能写
 * 3.构造方法中不能写return语句
 * 构造方法的注意事项：
 * 1.如果我们自己没有写任何的构造方法。系统会默认提供一个无参的构造方法。供我 们创建对象使用。
 * 2.如果自己写了一个有参的构造方法，那么系统就不会提供空参的构造方法了。
 * 构造方法重载：
 * 1.只要每个构造方法的参数类型或参数个数不同即可。
 */
public class Person {
    String name;
    int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void speak() {
        System.out.println("我叫：" + name + " 今年" + age + " 岁了!");
    }
}