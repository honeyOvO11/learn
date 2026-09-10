package shiyan6.exa10;

/**
 * 抽象类：
 * 1.什么是抽象类
 * 当我们进行父类抽取的时候，有些方法具体每个子类的实现方式都不太一样。
 * 那么这个时候，就应该把这个方法定义成抽象方法。有抽象方法的类一定是抽象。
 * 2.抽象类和抽象方法如何定义
 * abstract
 * 3.抽象类的成员特点
 * 成员变量：既可以变量，也可以有常量。
 * 成员方法: 即可有抽象方法，也可以有非抽象方法。
 * 构造方法：可以有构造方法。
 * 4.抽象类的注意事项
 * 抽象类不能实例化对象。
 */
public abstract class Animal {
    String name;
    String color;
    int age;

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public abstract void eat();
}
